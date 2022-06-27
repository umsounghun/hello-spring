package hello.hellospring.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long no;

    @Column(length = 50, nullable = true)
    private String id;

    @Column(length = 24, nullable = true)
    private String pwd;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;

    @Column(length = 14, nullable = true)
    private String name;

    @Builder
    public Member(String id, String pwd, Date regdate, String name) {
        this.id = id;
        this.pwd = pwd;
        this.regdate = regdate;
        this.name = name;
    }
}