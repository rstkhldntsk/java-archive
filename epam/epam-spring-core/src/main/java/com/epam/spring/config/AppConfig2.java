package com.epam.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.epam.spring.beans", "com.epam.spring.postProcessors"})
public class AppConfig2 {
}
