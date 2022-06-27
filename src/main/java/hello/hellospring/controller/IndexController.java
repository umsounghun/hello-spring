package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.hellospring.dto.BoardDto;
import hello.hellospring.dto.PostsSaveRequestDto;
import hello.hellospring.service.BoardService;
import hello.hellospring.service.PostsService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class IndexController {

    private PostsService postsService;
    private BoardService boardService;

    @PostMapping("/posts")
    public String savePosts(PostsSaveRequestDto dto) {
        postsService.save(dto);
        return "redirect:/";
    }

    @GetMapping("/")
    public String home(Model model, BoardDto dto) {
        model.addAttribute("boardList", boardService.allSelect(dto));

        return "index";
    }
}
