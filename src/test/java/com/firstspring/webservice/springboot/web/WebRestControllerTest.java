package com.firstspring.webservice.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
//테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
//여기서는 Spring Runner라는 스프링 실행자를 사용
//@RunWith는 스프링부트테스트와 JUnit사이에 연결자 역할

@WebMvcTest(controllers = WebRestController.class)
//Web(Spring MVC)에 집중할 수 있는 어노테이션
//선언할 경우
// 사용 가능 : @Controller, @ControllerAdvice
// 사용 불가능 : @Service, @Component, @Repository

public class WebRestControllerTest {

    @Autowired  //스프링이 관리하는 Bean을 주입
    private MockMvc mvc; //웹 API를 테스트할 때 사용, 스프링 MVC테스트의 시작점
    //이 클래스를 통해 HTTP,GET,POST등에 대한 API 테스트 가능

    @Test
    public void returnHello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                //MockMvc를 통해 /hello 주소로 HTTP GET 요청
                //체이닝이 지원되어 아래와 같이 여러 검증기능 이어서 선언 가능
                .andExpect(status().isOk())
                //mvc.perform의 결과 검증, HTTP Header의 Status(200,404,500..) 검증
                .andExpect(content().string(hello));
                //mvc.perform의 결과 검증, 응답 본문의 내용 검증
    }

    @Test
    public void returnHelloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                    get("/hello/dto")
                            .param("name", name)
                            .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name", is(name)))
                .andExpect((ResultMatcher) jsonPath("$.amount", is(amount)));
        //param : API 테스트할 때 사용될 요청파라미터를 설정, 값은 string만 허용, 숫자/날짜 등의 데이터도 작성할 때는 문자열로 변경해야함
        //jsonPath : JSON 응답값을 필드별로 검증, $을 기준으로 필드명 명시

    }
}