package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "member_id") //pk명
  private Long id;

  private String name;

  @Embedded
  private Address address;

  @OneToMany(mappedBy="member")  //mappedBy: 매핑된 거울이다(읽기전용), order 테이블 속 member필드로 매핑이 된거다!
  private List<Order> orders = new ArrayList<>();
}
