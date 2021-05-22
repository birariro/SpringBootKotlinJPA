package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 는 10% 할인이 적용되어야한디.")
    void vip_o(){

        Member member = new Member(1L, "memberVIP", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertEquals(1000,discount);

    }

    @Test
    @DisplayName("VIP 가 아니면 할인이 적용되지 말아야한다")
    void  vip_x(){
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertEquals(0,discount);
    }

}