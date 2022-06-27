package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.aspectj.weaver.patterns.BindingAnnotationFieldTypePattern;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import hello.hellospring.domain.entity.Board;
import hello.hellospring.domain.repository.BoardRepository;
import hello.hellospring.dto.BoardDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class BoardService {
    private BoardRepository boardRepository;

    // no 기준으로 내림차순 정렬
    public Page<Board> allSelect(BoardDto dto) {
        // PageRequest.of(page, size, sort)
        // page = 0부터 시작한다
        return boardRepository.findAll(PageRequest.of(0, 10, Direction.DESC, "no"));
    }

    // 글 작성
    public Long save(BoardDto dto) {
        return boardRepository.save(dto.toEntity()).getNo();
    }

    // 글 조회
    public Optional<Board> boardSelect(long no) {
        return boardRepository.findByNo(no);
    }

    // 글 삭제
    public void boardDelete(long no) {
        boardRepository.deleteByNo(no);
    }

    // 글 수정
    public long boardUpdate(BoardDto dto) {
        Optional<Board> optionalBoard = boardRepository.findByNo(dto.getNo());

        BoardDto board = new BoardDto(optionalBoard.get());
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());

        return boardRepository.save(board.toEntity()).getNo();
    }
}
