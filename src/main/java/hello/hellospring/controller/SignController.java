package hello.hellospring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.hellospring.domain.entity.Member;
import hello.hellospring.dto.MemberSignDto;
import hello.hellospring.service.MemberService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class SignController {

    private MemberService memberService;

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }

    @GetMapping("sign")
    public String signInForm() {
        return "sign/signInForm";
    }

    @PostMapping("sign-in")
    public String signIn(HttpSession session, MemberSignDto dto) {
        Member member = memberService.ok(dto);

        if (member != null) {
            session.setAttribute("log", "Y");
            session.setAttribute("logId", member.getId());
            session.setAttribute("logName", member.getName());
            return "redirect:/";
        } else {
            return "sign/failed";
        }

    }
}
