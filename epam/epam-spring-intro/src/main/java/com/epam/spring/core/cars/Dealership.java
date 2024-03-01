package com.epam.spring.core.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dealership {

    Car audi;
    Car bentley;
    Car rangeRover;

    @Autowired
    public void setAudi(Car audi) {
        this.audi = audi;
    }

    @Autowired
    public void setBentley(@Qualifier("bentley") Car bentley) {
        this.bentley = bentley;
    }

    @Autowired
    public void setRangeRover(@Qualifier("rangeRover") Car rangeRover) {
        this.rangeRover = rangeRover;
    }
}
