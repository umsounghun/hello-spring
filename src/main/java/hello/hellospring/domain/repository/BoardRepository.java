package hello.hellospring.domain.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.domain.entity.Board;
import hello.hellospring.dto.BoardDto;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findAll(Pageable pageable);

    Optional<Board> findByNo(long no);

    void deleteByNo(long no);

}
