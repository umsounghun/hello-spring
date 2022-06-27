package hello.hellospring.dto;

import java.util.Date;

import hello.hellospring.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSignDto {

    private String id;
    private String pwd;
    private Date date;
    private String name;

    public Member toEntity() {
        return Member.builder().id(id).pwd(pwd).regdate(date).build();
    }

    @Builder
    public MemberSignDto(String id, String pwd, Date date, String name) {
        this.id = id;
        this.pwd = pwd;
        this.date = date;
        this.name = name;
    }
}
