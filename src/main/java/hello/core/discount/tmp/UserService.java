package hello.core.discount.tmp;

import hello.core.member.Member;

public interface UserService {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member , int price);



}
