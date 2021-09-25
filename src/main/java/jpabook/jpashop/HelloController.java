package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")

    public String Hello(Model model){
        model.addAttribute("data","hello!");
        return "hello"; //hello 템플릿을  찾아간다.

        //정적 컨텐트는 static , 렌더링이 필요한경우네는 templates 에 둔다
    }
}
