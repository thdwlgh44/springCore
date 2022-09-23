package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//빈 이름: 클래스명
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired //ac.getBean(MemberRepository.class)
    //생성자에 파라미터가 많아도 다 찾아서 자동으로 주입한다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
