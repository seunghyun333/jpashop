//package jpabook.jpashop;
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.transaction.annotation.Transactional;
//import jakarta.persistence.EntityManager;
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class MemberRepositoryTest {
//	@Autowired MemberRepository memberRepository;
//	@Test
//	@Transactional
//	public void testMember() {
//		Member member = new Member();
//		member.setUsername("memberA");
//		Long savedId = memberRepository.save(member);
//		Member findMember = memberRepository.find(savedId);
//		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//
//		Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//		Assertions.assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
//	}
//}