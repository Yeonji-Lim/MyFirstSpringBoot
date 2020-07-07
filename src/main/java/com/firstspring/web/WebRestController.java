package com.firstspring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@ResponseBody를 모든 메소드에서 적용
public class WebRestController {

    //hello 메소드의 결과는 HelloWorld라는 문자열을 JSON형태로 반환
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
}
