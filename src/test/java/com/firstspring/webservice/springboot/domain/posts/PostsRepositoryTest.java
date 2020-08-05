package com.firstspring.webservice.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest //별다른 설정 없으면 h2 데이터베이스 자동 실행
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  //Junit에서 단위테스트가 끝날 때마다 수행되는 메소드
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given : 테스트 기반 환경을 구축하는 단계
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //@Builder의 사용법
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("view7186@naver.com")
                .build());
        //postsRepository.save : 테이블 posts에 id값이 있다면 update, 아니면 insert 쿼리 실행

        //when : 테스트 하고자 하는 행위 선언
        List<Posts> postsList = postsRepository.findAll();
        //posts가 DB에 insert되는 것을 확인하기 위함, 테이블 posts에 있는 모든 데이터 조회

        //then : 테스트 결과 검증
        //실제로 DB에 insert되었는 지 확인하기 위해 조회 후 입력된 값 확인
        Posts posts = postsList.get(0);
        //assertThat(posts.getTitle(), is(title));  //이건 Assert.assertThat
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_register() {
        //given
        LocalDateTime now = LocalDateTime.of(2020,03,17,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>>>>>> createDate="+posts.getCreateDate()+", modifiedDate="+posts.getCreateDate());

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}