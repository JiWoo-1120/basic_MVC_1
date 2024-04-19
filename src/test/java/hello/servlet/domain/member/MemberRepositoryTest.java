package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    //테스트가 끝나면 테스트를 깔끔하게 초기화 하는 코드
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void getInstance() {
    }

    @Test
    void save() {
        //given(이런게 주어졌을 때)
        Member member = new Member("hello", 20);

        //when(이런게 실행되었을 때)
        Member saveMember = memberRepository.save(member);

        //then(결과가 이거여야 한다.)
        //1.비교하기 위해 저장된 아이드를 불러온다.
        Member findMember = memberRepository.findById(saveMember.getId());
        //2.findMember는 saveMember와 같아야한다.
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        //given(이런게 주어졌을 때)
        Member member = new Member("jiwoo", 20);
        Member member1 = new Member("suin", 20);
        memberRepository.save(member);
        memberRepository.save(member1);
       

        //when(이런게 실행되었을 때)
        List<Member> findAllId = memberRepository.findAll();

        //then(결과가 이거여야 한다.)
        assertThat(findAllId.size()).isEqualTo(2);
        //findAllId안에 member, member1이 있는지
        assertThat(findAllId).contains(member, member1);

    }

    @Test
    void clearStore() {
    }
}