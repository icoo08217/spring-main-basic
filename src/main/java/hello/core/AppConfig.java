package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링에서 설정정보를 뜻하는 어노테이션.
// 스프링 설정 정보는 항상 @Configuration 어노테이션을 사용하자!
public class AppConfig { // 애플리케이션의 전체를 설정한다는 클래스. // 의존성을 주입해주었다.

    //@Bean memberService --> new MemoryMemberRepository()
    //@Bean orderService --> new MemoryMemberRepository()  2번 호출됨. 싱글톤이 깨지는건 아닐까 ?

    @Bean // 스프링 컨테이너에 등록이 된다.
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 생성자 주입!!
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 주입 . Injection

    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
