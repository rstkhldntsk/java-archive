package com.epam.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("application.properties")
public class BeanC {

    @Value("${beanC.name}")
    String name;

    @Value("${beanC.value}")
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
        return "BeanC: " +
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
