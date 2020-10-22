package com.example.Springboot_Start.dto;

import com.example.Springboot_Start.web.dto.HelloresponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloresponseDtoTest {
    @Test
    public void lombokTest()
    {
        String name = "test";
        int amount =1000;

        HelloresponseDto dto = new HelloresponseDto(name,amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
