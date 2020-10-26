package com.example.Springboot_Start.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloresponseDtoTest {
    @Test
    public void lombokTest()
    {
        String name = "test";
        int amount =1000;

        HelloresponseDto dto = new HelloresponseDto(name,amount); //자동으로 생성된 생성자에 데이터를 넣는다.

        assertThat(dto.getName()).isEqualTo(name); //테스트 검증 라이브러리이다. 검증하고싶은 대상을 메소드 인자로 넣는다.
        assertThat(dto.getAmount()).isEqualTo(amount); //isEqualTo 는 비교 메소드이다.
    }

}
