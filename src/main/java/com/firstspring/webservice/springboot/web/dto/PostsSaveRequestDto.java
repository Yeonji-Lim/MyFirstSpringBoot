package com.firstspring.webservice.springboot.web.dto;

//entity 클래스와 거의 유사한 형태임에도 dto클래스를 추가로 생성함
//하지만 절대로 entity클래스를 request/response 클래스로 사용해서는 안됨

import com.firstspring.webservice.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {

        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
