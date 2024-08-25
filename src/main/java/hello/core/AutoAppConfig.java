package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록함
@ComponentScan(
        // 스캔 시작점 지정하지 않을시 - @ComponentScan이 붙은 클래스의 패키지부터 시작, 하위 패키지 모두 탐색
        // 컴포넌트 스캔 시작 위치 지정, 해당 패키지 기준 하위 패키지 모두 탐색, 여러개 지정도 가능
        basePackages = "hello.core",
        // 해당 클래스의 패키지를 탐색 시작 위치로 지정
        basePackageClasses = AutoAppConfig.class,
        // 권장 방법 -> 패키지 위치를 지정하지 않고 @ComponentScan 클래스를 프로젝트 최상단에 두는 것
        // 스프링부트에선 @SpringBootApplication을 프로젝트 시작 루트 위치에 둠(설정안에 @ComponentScan이 들어있음)
        // 컴포넌트 스캔 제외할 컴포넌트 - 기존 예제코드 남겼기에 해당 @Configuration 제외하기위해 추가함
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 수동 빈 등록이 우선권 가짐(수동빈이 자동빈 오버라이딩) -> 스프링부트에선 충돌
    /*@Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}