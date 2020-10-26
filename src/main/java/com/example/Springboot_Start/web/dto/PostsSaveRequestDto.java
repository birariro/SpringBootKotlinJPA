package com.example.Springboot_Start.web.dto;

import com.example.Springboot_Start.domain.posts.Posts;
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
    public PostsSaveRequestDto(String title , String content , String author){
        this.title = title;
        this.content = content;
        this.author = author;

    }
    //데이터베이스에 저장시킬 폼
    public Posts toEntity(){
        return Posts.builder().title(title).content(content).author(author).build();
    }
}
