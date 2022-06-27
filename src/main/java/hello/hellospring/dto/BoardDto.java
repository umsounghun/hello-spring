package hello.hellospring.dto;

import java.util.Date;

import hello.hellospring.domain.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BoardDto {

    private long no;
    private String title;
    private String content;
    private String author;
    private Date writedate;
    private int views;

    // DTO를 Entity로 반환한다
    public Board toEntity() {
        return Board.builder().no(no).title(title).content(content).author(author).writedate(writedate).views(views)
                .build();
    }

    @Builder
    public BoardDto(Board board) {
        this.no = board.getNo();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.author = board.getAuthor();
        this.writedate = board.getWritedate();
        this.views = board.getViews();
    }

}
