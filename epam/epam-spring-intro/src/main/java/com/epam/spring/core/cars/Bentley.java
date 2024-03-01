package com.epam.spring.core.cars;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Bentley implements Car {

    public Bentley() {
        System.out.println("Bentley wroom-wroom");
    }

    @Override
    public String toString() {
        return "Bentley Continental GT";
    }
}
