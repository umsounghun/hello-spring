package hello.hellospring.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hello.hellospring.domain.entity.Member;
import hello.hellospring.domain.repository.MemberRepository;
import hello.hellospring.dto.MemberSignDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    void 아이디_비밀번호로_조회() {
        // given
        MemberSignDto dto = MemberSignDto.builder().id("test").pwd("test").build();

        // when
        Member member = memberRepository.findMember(dto.getId(), dto.getPwd());

        // then
        if (member != null) {
            System.out.println(member.getId());
            System.out.println(member.getName());
            assertThat(member.getId(), is("test"));
            assertThat(member.getName(), is("test"));
        } else {
            assertThat("", is(""));

        }

    }
}
