package hello.hellospring.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import hello.hellospring.domain.entity.Posts;
import hello.hellospring.domain.repository.PostsRepository;
import hello.hellospring.dto.PostsSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다() {
        // given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder().author("kyungsik0907@gmail.com").content("테스트")
                .title("테스트 타이틀").build();

        // when
        postsService.save(dto);

        // then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor(), is(dto.getAuthor()));
        assertThat(posts.getContent(), is(dto.getContent()));
        assertThat(posts.getTitle(), is(dto.getTitle()));
    }
}
