package hello.hellospring.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import hello.hellospring.domain.entity.Member;
import hello.hellospring.domain.repository.MemberRepository;
import hello.hellospring.dto.MemberSignDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService {
    private MemberRepository memberRepository;

    // id와 비밀번호가 일치하는 회원 조회
    @Transactional
    public Member ok(MemberSignDto dto) {
        return memberRepository.findMember(dto.getId(), dto.getPwd());
    }
}
