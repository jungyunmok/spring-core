package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    // 실행하면 스프링에 등록된 모든 빈 정보 출력
    void findAllBean() {
        // ac.getBeanDefinitionNames(): 스프링에 등록된 모든 빈 이름 조회
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            // ac.getBean(): 빈 이름으로 빈 객체(인스턴스)를 조회함
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " / obj = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    // 스프링 내부에서 사용하는 빈 제외, 내가 등록한 빈만 출력 -> getRole()로 구분
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // ROLE_APPLICATION: 직접 등록한(일반적으로 사용자가 정의한) 애플리케이션 빈
            // ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " / obj = " + bean);
            }
        }
    }
}
