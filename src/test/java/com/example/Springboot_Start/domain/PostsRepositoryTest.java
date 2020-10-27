package com.example.Springboot_Start.domain;

import com.example.Springboot_Start.domain.posts.Posts;
import com.example.Springboot_Start.domain.posts.PostsRepository;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After //테스트가 끝날때 수행할 메소드를 지정
    public void clenup()
    {
        postsRepository.deleteAll();
    }
    @Test
    public void Text_sava_road()
    {
        String title ="테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() //테이블 posts에 insert/update를 실행한다 id가있다면 update , 없다면 insert 실행
        .title(title)
        .content(content)
        .author("k4keye@naver.com")
        .build());

        List<Posts> postsList = postsRepository.findAll(); //posts 테이블에 있는 모든 데이터 조회

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
    @Test
    public void BaseTimeEntity_Test()
    {
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder().title("title").content("content").author("author").build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);
        System.out.println("createDate="+posts.getCreatedDate()+" , modifiedDate="+posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
