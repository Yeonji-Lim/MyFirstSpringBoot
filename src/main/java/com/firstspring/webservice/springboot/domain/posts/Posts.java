package com.firstspring.webservice.springboot.domain.posts;

//Posts 클래스는 setter 메소드가 없다. Entity클래스에서는 절대 setter클래스를 만들지 않는다.

import com.firstspring.webservice.springboot.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity //테이블과 링크될 클래스임을 나타냄, 언더스코어 네이밍으로 이름을 매칭함
public class Posts extends BaseTimeEntity {    //실제 DB의 테이블과 매칭될 클래스이며 보통 entity클래스라고도 함

    @Id //해당 테이블의 PK필드
    @GeneratedValue //PK 생성 규칙, 스프링부트2.0에서는 GenerationType.Identity 옵셥을 추가해야 auto_increment가 됨
    private Long id;

    //@Column : 테이블의 컬럼을 나타냄, 굳이 선언하지 않더라도 해당 클래스 필드는 모두 컬럼
    //          기본값 외에 추가로 변경이 필요한 옵션이 있는 경우 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    //@Builder : 해당 클래스의 필더 패턴 클래스를 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
