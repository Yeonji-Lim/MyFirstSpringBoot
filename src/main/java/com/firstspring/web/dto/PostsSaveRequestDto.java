package com.firstspring.web.dto;

//절대로 테이블과 매핑되는 Entity클래스를 Request/Response 클래스로 사용해서는 안된다
//Entity 클래스 : 가장 core한 클래스, 수많은 서비스 클래스나 비즈니스 로직들이 Entity클래스를 기준으로 동작, 변경시 여러 클래스에 영향
//반면 Request와 Response용 DTO는 View를 위한 클래스여서 자주 변경 필요
//View Layer와 DB Layer를 철저하게 역할 분리를 하는 것이 좋음 Entity와 Controller에서 쓸 DTO는 꼭 분리해서 사용하자

import com.firstspring.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//Controller에서 @RequestBody로 외부에서 데이터를 받는 경우엔
//기본생성자 + set메소드를 통해서만 값이 할당됨
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
