package com.epam.spring.postProcessors;

import com.epam.spring.Validation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class<?> beanClass = bean.getClass();
        if (!beanClass.isAnnotationPresent(Validation.class)) {
            return bean;
        }

        try {
            Field name = beanClass.getDeclaredField("name");
            name.setAccessible(true);
            if (name.get(bean) == null) {
                throw new IllegalArgumentException("Name can not be null");
            }

            Field val = beanClass.getDeclaredField("value");
            val.setAccessible(true);

            if ((int) val.get(bean) < 0) {
                throw new IllegalArgumentException("Value must be positive");
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalArgumentException();
        }
        return bean;
    }

}
