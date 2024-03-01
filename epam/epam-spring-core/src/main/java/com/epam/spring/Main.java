package com.epam.spring;

import com.epam.spring.beans.*;
import com.epam.spring.config.AppConfig1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);
        System.out.println("--------------------------------------");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean(BeanD.class));
        System.out.println(context.getBean(BeanB.class));
        System.out.println(context.getBean(BeanA.class));
        System.out.println(context.getBean(BeanC.class));
        System.out.println(context.getBean(BeanE.class));
        System.out.println(context.getBean(BeanF.class));
        System.out.println("--------------------------------------");
        context.close();
    }

}
