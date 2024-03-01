package com.epam.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("application.properties")
@Component
public class BeanD {

    @Value("${beanD.name}")
    String name;

    @Value("${beanD.value}")
    Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanD: " +
                "name= " + name + ' ' +
                ", value= " + value +
                ';';
    }

    void initMethod() {
        System.out.println(this.getName() + " init");
    }

    void destroyMethod() {
        System.out.println(this.getName() + " destroy");
    }

}
