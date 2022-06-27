//package hello.hellospring.domain.posts;
//
//import static org.hamcrest.MatcherAssert.assertThat;
////import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.is;
//
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import hello.hellospring.domain.entity.Posts;
//import hello.hellospring.domain.repository.PostsRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class PostsRepositoryTest {
//
//    @Autowired
//    PostsRepository postsRepository;
//
//    @After
//    public void cleanup() {
//        // 테스트 메소드가 끝날때 마다 전체 비우는 코드
//        postsRepository.deleteAll();
//    }
//
//    @Test
//    public void 게시글저장_불러오기() {
//        // given
//        postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("kyungsik@gmail.com").build());
//
//        // when
//        List<Posts> postsList = postsRepository.findAll();
//
//        // then
//        Posts posts = postsList.get(0);
//        assertThat(posts.getTitle(), is("테스트 게시글"));
//        assertThat(posts.getContent(), is("테스트 본문"));
//
//    }
//
//    // @Test
//    // public void BaseTimeEntity_등록() {
//    // // given
//    // LocalDateTime now = LocalDateTime.now();
//
//    // postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트
//    // 본문").author("kyungsik@gmail.com").build());
//
//    // // when
//    // List<Posts> postsList = postsRepository.findAll();
//
//    // // then
//    // Posts posts = postsList.get(0);
//    // assertTrue(posts.getCreatedDate().isAfter(now));
//    // assertTrue(posts.getModifiedDate().isAfter(now));
//    // }
//
//}
