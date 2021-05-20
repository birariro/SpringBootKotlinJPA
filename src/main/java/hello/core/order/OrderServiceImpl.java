package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepositoty;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepositoty();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    //여기서 단일 책임 원칙이 나오게된다.
    //서비스 입장에서 할인 정책이 어떻게 되던간에 이 처리를 DiscountPolicy 에게 위임하는것으로
    //할인정책이 변경되어도 이 서비스가 변경되는 경우는 발생하지않는다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
