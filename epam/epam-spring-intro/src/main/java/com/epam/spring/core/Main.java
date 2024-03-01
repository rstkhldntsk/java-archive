package com.epam.spring.core;

import com.epam.spring.core.cars.CarContainer;
import com.epam.spring.core.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("-----------------------");

        ctx.getBean(CarContainer.class).printCars();
    }
}
