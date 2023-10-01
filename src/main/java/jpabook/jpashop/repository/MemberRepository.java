package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 안에 component가 들어있어서 자동으로 빈에 주입이 됨
public class MemberRepository {

  @PersistenceContext //엔티티매니저를 주입 받는 기능
  private EntityManager em;

  public void save(Member member) {
    em.persist(member); //멤버 저장
  }

  public Member findOne(Long id) {
    return em.find(Member.class, id); //멤버를 찾아서 반환 //class는 타입, id는 pk값// 단건 조회
  }

  public List<Member> findAll() {
    List<Member> result = em.createQuery("select m from Member m", Member.class)  //JPQL SQL은 테이블을 대상으로, JPQL은 ENTITY를 대상으로
            .getResultList(); // 반환 타입

    return result;
  }

  public List<Member> findByName(String name) {
    return em.createQuery("select m from Member m where m.nae= :name", Member.class) // :name : 파라미터를 바인딩 , member.class: 조회타입
            .setParameter("name", name)
            .getResultList();
  }
}
