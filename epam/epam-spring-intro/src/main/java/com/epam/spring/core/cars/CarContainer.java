package com.epam.spring.core.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarContainer {

    @Autowired
    List<Car> cars;

    public void printCars(){
        for (Car car:cars) {
            System.out.println(car);
        }
    }

}
