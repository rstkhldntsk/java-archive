package com.epam.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.validation.Valid;

@PropertySource("application.properties")
public class BeanB {

    @Valid()
    @Value("${beanB.name}")
    String name;

    @Valid
    @Value("${beanB.value}")
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
        return "BeanB: " +
                "name= " + name + ' ' +
                ", value= " + value +
                ';';
    }

    void initMethod() {
        System.out.println(this.getName() + " init");
    }

    void anotherInit() {
        System.out.println(this.getName() + " anotherInit (set by MyBeanFactoryPostProcessor)");
    }

    void destroyMethod() {
        System.out.println(this.getName() + " destroy");
    }

}
