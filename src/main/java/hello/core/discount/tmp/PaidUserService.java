package hello.core.discount.tmp;

import hello.core.member.Grade;
import hello.core.member.Member;

public class PaidUserService implements UserService {
    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) { //enum타입은 == 으로 비교한다.
            return discountFixAmount;
        } else{
            return 0;
        }

    }
}
