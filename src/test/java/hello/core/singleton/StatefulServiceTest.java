package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A사용자 10,000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        // ThreadB: B사용자 20,000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        // ThreadA: A사용자 주문 금액 조회 - 10,000원이 아니라 20,000이 출력됨
//        int price = statefulService1.getPrice();

        // 지역변수를 활용하면 제대로 10,000이 출력됨
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}