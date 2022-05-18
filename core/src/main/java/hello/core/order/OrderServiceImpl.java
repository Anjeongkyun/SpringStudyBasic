package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.DiscountPolicyImpl;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRespository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRespository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    DiscountPolicyImpl discountPolicyImpl = new DiscountPolicyImpl();
    private DiscountPolicy discountPolicy;

    @Override
    public Order craeteOrder(Long memberId, String itemName, int itemPrice) {
        discountPolicyImpl.setDiscountPolicy(rateDiscountPolicy);
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicyImpl.discount(member, itemPrice);

        return new Order(memberId,itemName, itemPrice, discountPrice);
    }
}
