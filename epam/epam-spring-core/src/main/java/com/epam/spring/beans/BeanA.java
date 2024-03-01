package com.epam.spring.beans;

import com.epam.spring.Validation;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Validation
public class BeanA implements InitializingBean, DisposableBean {

    String name;
    Integer value;

    public BeanA(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

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
        return "BeanA: " +
                "name= " + name + ' ' +
                ", value= " + value +
                ';';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getName() + " destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getName() + " afterPropertiesSet");
    }

}
