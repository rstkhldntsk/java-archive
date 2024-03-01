package com.epam.spring.core.cars;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Audi implements Car {

    public Audi() {
        System.out.println("Audi created");
    }

    @Override
    public String toString() {
        return "Audi RS6";
    }
}
