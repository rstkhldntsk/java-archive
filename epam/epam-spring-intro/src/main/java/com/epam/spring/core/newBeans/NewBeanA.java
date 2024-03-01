package com.epam.spring.core.newBeans;

import com.epam.spring.core.otherBeans.OtherBeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NewBeanA {

    @Qualifier(value = "otherBeanA")
    private OtherBeanA beanA;

    @Autowired
    public NewBeanA(OtherBeanA beanA) {
        this.beanA = beanA;
    }
}
