package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.cache.spi.support.AbstractRegion;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {

  @Id
  @GeneratedValue
  @Column(name = "order_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name ="member_id") // 매핑하는 주체! member_id는 fk 명
  private Member member;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItem> orderItems = new ArrayList<>();

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="delivery_id")
  private Delivery delivery;

  private LocalDateTime orderDate; //주문시간

  @Enumerated(EnumType.STRING)
  private OrderStatus status; //주문상태 [ORDER, CANCEL]

  //연관관계 편의메서드
  public void setMember(Member member) {
    this.member = member;
    member.getOrders().add(this);
  }

  public void addOrderItem(OrderItem orderItem) {
    orderItems.add(orderItem);
    orderItem.setOrder(this);
  }

  public void setDeliver(Delivery delivery) {
    this.delivery = delivery;
    delivery.setOrder(this);
  }
}
