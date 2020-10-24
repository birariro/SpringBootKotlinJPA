package com.example.Springboot_Start.web;

import com.example.Springboot_Start.web.dto.HelloresponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloresponseDto helloDto(@RequestParam("name") String name , @RequestParam("amount") int amount)
    {
        return new HelloresponseDto(name,amount);
    }
}
