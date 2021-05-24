package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class AppConfig {

    //이곳에서 구현체를 주입해주는것으로 OCP를 지킨다.
    //기본적으로 메소드 이름을 빈 이름으로한다.
    @Bean
    public MemberService memberService(){
        return  new MemberServiceImpl(MemberRepository());
    }
    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
