package com.epam.spring.config;

import com.epam.spring.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

@Configuration
@Import({AppConfig2.class})
public class AppConfig1 {

    @Order(1)
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    BeanD beanD() {
        return new BeanD();
    }

    @Order(2)
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    BeanB getBeanB() {
        return new BeanB();
    }

    @Order(3)
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    BeanC getBeanC() {
        return new BeanC();
    }

    @Bean
    BeanA getBeanA(){
        return new BeanA("beanA", 1);
    }

    @Bean
    BeanE getBeanE(){
        return new BeanE("beanE", 5);
    }

    @Bean
    @Lazy
    BeanF getBeanF(){
        return new BeanF("beanF", 6);
    }

}
