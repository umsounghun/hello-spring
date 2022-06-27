package hello.hellospring.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import hello.hellospring.domain.entity.Board;
import hello.hellospring.domain.repository.BoardRepository;
import hello.hellospring.dto.BoardDto;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class BoardServiceTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    void 게시글_작성_테스트() {
        // given
        BoardDto dto = new BoardDto(
                Board.builder().title("testcase").content("textcaseContent").author("test").build());

        // when
        Long result = boardRepository.save(dto.toEntity()).getNo();
        Optional<Board> board = boardRepository.findByNo(result);

        // then
        assertThat(board.get().getNo(), is(result));

    }

    @Test
    void 업데이트_테스트() {
        // given
        int no = 10;
        String title = "update테스트";
        String content = "update테스트";
        // when
        BoardDto dto = new BoardDto(boardRepository.findByNo(no).get());

        dto.setTitle(title);
        dto.setContent(content);
        Board board = boardRepository.save(dto.toEntity());

        // then
        assertThat(board.getTitle(), is(title));
        assertThat(board.getTitle(), is(content));
    }
}
