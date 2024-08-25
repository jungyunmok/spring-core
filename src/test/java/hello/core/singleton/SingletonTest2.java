package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest2 {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        // private으로 생성자 막아두었기에 아래 코드는 컴파일 오류 발생
//        new SingletonService();

        // 1. 조회" 호출할 때마다 같은 객체 반환
        SingletonService singletonService1 = SingletonService.getInstance();
        // 2. 조회" 호출할 때마다 같은 객체 반환
        SingletonService singletonService2 = SingletonService.getInstance();

        // 참조값이 같음
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
        // same: ==
        // equal: .equals()

        singletonService1.logic();
    }
}