package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service  // 안에 component가 들어있어서 자동으로 빈에 주입이 됨
@Transactional(readOnly = true) // 모든 데이터, 로직 변경은 가급적 transaction안에서 실행되어야함.  //리드온리 속도 최적화함. 읽기엔 작 건 바다아
@RequiredArgsConstructor
public class MemberService {

  private MemberRepository memberRepository;

  
  //회원가입
  @Transactional
  public Long join(Member member) {

    validateDuplicateMember(member);//중복 회원 검증
    memberRepository.save(member);
    return  member.getId();
  }


  private void validateDuplicateMember(Member member) {
    List<Member> findMembers = memberRepository.findByName(member.getName());
    if (!findMembers.isEmpty()) {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    }
  }


  //회원 전체 초회
 //리드온리 속도 최적화함. 읽기엔 작 건 바다아
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }


  public Member findOne(Long memberId) {
    return memberRepository.findOne(memberId);
  }
}
