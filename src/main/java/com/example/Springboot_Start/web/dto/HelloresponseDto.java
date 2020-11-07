package com.example.Springboot_Start.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성한다. final이 선언되지않은 변수는 포함하지않는다.
@Getter //선언된 필드에 GET 메소드를 생성한다.
//dto란 응답할 데이터의 포멧이라고 볼수있다.
public class HelloresponseDto {
    private  String name;
    private  int amount;
    @Builder
    public HelloresponseDto(String name , int amount)
    {
        this.name = name;
        this.amount = amount;
    }
}
