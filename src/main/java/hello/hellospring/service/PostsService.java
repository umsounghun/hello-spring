package hello.hellospring.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import hello.hellospring.domain.repository.PostsRepository;
import hello.hellospring.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }
}
