package com.rog.teach.simpleSpring.config;

import com.rog.teach.simpleSpring.entity.BeanWithDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

public class AnotherConfiguration {

    @Autowired
    private Environment env;

    @Bean
    BeanWithDependency beanWithDependency() {
        BeanWithDependency beanWithDependency = new BeanWithDependency();
        beanWithDependency.setText(env.getProperty("custom.example"));
        return beanWithDependency;
    }
}
