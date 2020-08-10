package com.firstspring.webservice.springboot.domain.posts;

import com.firstspring.webservice.springboot.web.dto.PostsResponseDto;
import com.firstspring.webservice.springboot.web.dto.PostsSaveRequestDto;
import com.firstspring.webservice.springboot.web.dto.PostsUpdateRequestDto;
import com.firstspring.webservice.springboot.web.dto.PostslistResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        postsRepository.delete(posts);  //JPARepository에서 지원하는 delete메소드
        //엔티티를 파라미터로 삭제할 수도 있고 deleteById메소드를 이용하면 id를 삭제할 수도 있음
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) //트랜잭션 범위는 유지하되 조회 기능만 남겨두어 조회속도가 개선 -> 등록, 수정, 삭제 기능이 전혀 없는 서비스 메소드에서 주로 사용
    public List<PostslistResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostslistResponseDto::new)
                .collect(Collectors.toList());
    }
}
