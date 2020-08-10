package com.firstspring.webservice.springboot.web;

import com.firstspring.webservice.springboot.domain.posts.PostService;
import com.firstspring.webservice.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        //Model : 서버 템플릿 엔진에서 사용할 수 있는 객체를 지정 가능
        model.addAttribute("posts", postService.findAllDesc());
        //postService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
