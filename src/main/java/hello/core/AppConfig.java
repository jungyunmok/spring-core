package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* @Configuration이 붙으면 설정(구성) 정보로 사용함
* 여기서 @Bean이라 적힌 메서드 모두 호출해 반환된 객체를 스프링 컨테이너에 등록함
* 이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라 함
* 스프링 빈은 @Bean이 붙은 메서드 명을 스프링 빈의 이름으로 사용함
* 스프링 빈은 applicationContext.getBean() 메서드로 찾을 수 있음
*/
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // FixDiscountPolicy -> RateDiscountPolicy
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}