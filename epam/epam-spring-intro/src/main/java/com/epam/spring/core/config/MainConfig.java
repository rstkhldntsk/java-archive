package com.epam.spring.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        AppConfig1.class,
        AppConfig2.class
})
@ComponentScan(basePackages = {"com.epam.spring.core.cars"})
public class MainConfig {
}