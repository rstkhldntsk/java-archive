package com.epam.spring.core.cars;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Primary
@Order(2)
public class RangeRover implements Car {

    public RangeRover() {
        System.out.println("Range Rover is big");
    }

    @Override
    public String toString() {
        return "Range Rover Velar";
    }
}
