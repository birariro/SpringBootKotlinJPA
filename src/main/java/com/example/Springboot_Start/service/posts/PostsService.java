package com.example.Springboot_Start.service.posts;

import com.example.Springboot_Start.domain.posts.Posts;
import com.example.Springboot_Start.domain.posts.PostsRepository;
import com.example.Springboot_Start.web.dto.PostsListResponseDto;
import com.example.Springboot_Start.web.dto.PostsResponseDto;
import com.example.Springboot_Start.web.dto.PostsSaveRequestDto;
import com.example.Springboot_Start.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).getId();
    }
    //데이터베이스에 저장을 시키고 ID를 반환
    @Transactional
    public Long update(Long id , PostsUpdateRequestDto requestDto)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없다 id = "+id));

        posts.update(requestDto.getTitle() , requestDto.getContent());
        return id;
    }
    public PostsResponseDto findById(Long id)
    {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없다 id = "+id));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new)
                .collect(Collectors.toList());

    }
}
