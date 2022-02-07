package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component가 붙은 클래스들을 스프링 컨테이너에 자동으로 등록해준다.
        basePackages = "hello.core", // 컴포넌트 스캔 탐색 위치를 지정할 수 있다.
        // 지정하지 않으면 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 탐색 시작 위치가 된다.
        // @Configuration이 붙은 설정 정보도 자동으로 등록된다. 그래서 아래 excludeFilters로 제외시켜주었다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION , classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
