package com.example.Springboot_Start.domain.posts;

import com.example.Springboot_Start.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //모든 필드 GET 메소드 생성
@NoArgsConstructor //기본 생성자 자동추가.
@Entity //자신이 테이블과 링크될 클래스임을 알린다.

public class Posts  extends BaseTimeEntity {
    //Posts class 는 DB 테이블에 매칭될 클래스이다. Entity class 라고도한다.
    @Id //PK 라고 알린다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 스프링 규칙을 나타낸다.
    private Long id;

    @Column(length = 500 , nullable = false) //테이블의 컬럼으 나타낸다.
    private String title;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String content;

    private String author;

    @Builder //클래스의 빌더 패턴 클래스 생성
    public Posts(String title ,String content , String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title , String content)
    {
        this.title = title;
        this.content = content;
    }
}
