package hello.hellospring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.domain.entity.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
