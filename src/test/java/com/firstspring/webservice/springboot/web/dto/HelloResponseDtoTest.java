package com.firstspring.webservice.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombokFunctionTest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        //assertThat : assertj라는 테스트 검증 라이브러리의 검증 메소드
        //isEqualTo(검증하고 싶은 대상) : 메소드 체이닝이 지원
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}