package com.example.Springboot_Start.web;

import com.example.Springboot_Start.web.dto.HelloresponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 JSON 으로 반환하는 컨트롤러로 만들어준다.
public class HelloController {
    @GetMapping("/hello") //GET 요청을 받을수있는 API로 만든다.
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloresponseDto helloDto(@RequestParam("name") String name , @RequestParam("amount") int amount)
    { //외부에서 API 넘긴 파라미터를 가져오는 어노테이션 이다.
        return new HelloresponseDto(name,amount);
    }
}
