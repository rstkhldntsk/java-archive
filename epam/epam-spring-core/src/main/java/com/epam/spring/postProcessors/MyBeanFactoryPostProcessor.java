package com.epam.spring.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        try {
            BeanDefinition beanB = configurableListableBeanFactory.getBeanDefinition("getBeanB");
            beanB.setInitMethodName("anotherInit");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
