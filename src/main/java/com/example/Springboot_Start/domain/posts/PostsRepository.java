package com.example.Springboot_Start.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
//Posts class 로 DB를 접근하게해줄 JpaRepository이다.
    //보통 DAO 라고 불리는 DB 접근자이다.
    //JPA 에서는 Repository 라고 불리며 인터페이스로 생성한다.
    //단순히 인터페이스 생성후 <Entoty 클래스 , PK 타입> 을 상속하면 기본 CRUD 메소드가 생성된다.
}
