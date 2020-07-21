package com.firstspring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //예전에는 @ResponseBody를 모든 메소드에서 적용, 지금은 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줌
public class WebRestController {

    //hello 메소드의 결과는 HelloWorld라는 문자열을 JSON형태로 반환
    @GetMapping("/hello")   //HTTP Method이 Get인 요청을 받을 수 있는 API를 만들어준다
    //예전에는 @RequestMapping(method = RepuestMethod.GET)
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}
