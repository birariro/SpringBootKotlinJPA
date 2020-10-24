package com.example.Springboot_Start.web;


import com.example.Springboot_Start.service.posts.PostsService;
import com.example.Springboot_Start.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto)
    {
        return postsService.save(requestDto);
    }
    //사용자가 어떻게 DTO를 사용한것인가?
    //클라이언트 -> DTO - web레이어 순서인가?
}
