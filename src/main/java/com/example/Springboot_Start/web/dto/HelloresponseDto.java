package com.example.Springboot_Start.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class HelloresponseDto {
    private final String name;
    private final int amount;
}
