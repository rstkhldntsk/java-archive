package com.epam.spring.core.newBeans;

import com.epam.spring.core.otherBeans.OtherBeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewBeanC {

    private OtherBeanC beanC;

    @Autowired
    public void setBeanC(OtherBeanC beanC) {
        this.beanC = beanC;
    }
}
