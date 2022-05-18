package hello.core.discount;

import hello.core.member.Member;

public class DiscountPolicyImpl implements  DiscountPolicy{

    private DiscountPolicy discountPolicy;

    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
    }

    @Override
    public int discount(Member member, int price) {
        return discountPolicy.discount(member,price);
    }
}
