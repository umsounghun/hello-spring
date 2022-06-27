package hello.hellospring.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long no;

    @Column(length = 500, nullable = true)
    private String title;

    @Column(length = 1000, nullable = true)
    private String content;

    @Column(length = 50, nullable = true)
    private String author;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date writedate;

    private int views;

    @Builder
    public Board(long no, String title, String content, String author, Date writedate, int views) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.author = author;
        this.writedate = writedate;
        this.views = views;
    }
}
