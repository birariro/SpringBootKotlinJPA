package com.example.Springboot_Start;

import com.example.Springboot_Start.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class) //스프링 부트 실행자와 Junit 를 연결한다.
@WebMvcTest(controllers = HelloController.class) // controller ,controllerAdvice 등을 사용할수있다. (Service , Component , Repository는 불가)
//여기서는 Controller 을 사용하기때문에 사용.
public class HelloControllerTest {
    @Autowired //스피링을 관리하는 빈을 주입 받는다.
    private MockMvc mvc; //웹 api를 테스트할때 사용한다. 이 클래스를 통해 GET, POST 테스트 가능

    @Test
    public void hello_Test_return() throws Exception{
        String hello = "hello!!";
        mvc.perform(get("/hello")) //MockMvc를 통해 /hello 주소로 GET을 요청한다.
                .andExpect(status().isOk()) //결과의 상태 코드를 확인한다.
                .andExpect(content().string(hello)); //결과의 내용을 확인한다.
    }

    @Test
    public void helloDto_Test_return() throws  Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
        .param("name",name) //API 테스트할 파라미터를 지정한다.
        .param("amount",String.
                valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //json응답값을 필드별로 검증
                .andExpect(jsonPath("$.amount",is(amount)));

    }
}
