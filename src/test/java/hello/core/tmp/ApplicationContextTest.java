package hello.core.tmp;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.discount.tmp.BasicUserService;
import hello.core.discount.tmp.PaidUserService;
import hello.core.discount.tmp.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 중복 오류 발생한다.")
    void test0(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                ()-> ac.getBean(DiscountPolicy.class));
    }
    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 빈이름을 지정하면된다.")
    void test1(){
        UserService basicUserService = ac.getBean("basicUserService", BasicUserService.class);
        Assertions.assertEquals(BasicUserService.class,basicUserService.getClass());
    }
    @Test
    @DisplayName("특정 하위 타입으로 조회 - 안좋은 방법")
    void findBeanBySubType(){
        UserService basicUserService = ac.getBean(BasicUserService.class);
        Assertions.assertEquals(BasicUserService.class,basicUserService.getClass());
    }
    @Test
    @DisplayName("부모 타입으로 모두 조회")
    void findAllBeanByParentType(){
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        Assertions.assertEquals(2,beansOfType.size());
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key +" value = "+ beansOfType.get(key));
        }
    }

    @Test
    @DisplayName("부모타입으로 모두 조회하기 - object")
    void findAllBeanByObjectType(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key +" value = "+beansOfType.get(key));
        }
    }

    @Configuration
    static class TestConfig{
        @Bean
        public UserService basicUserService(){
            return new BasicUserService();
        }
       /* @Bean
        public UserService paidUserService(){
            return new PaidUserService();
        }*/
    }
}
