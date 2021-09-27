package com.rog.teach.annotation;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class ConfigBean {

    @Bean
    private InjectRandomIntAnnotationBeanPostProcessor injectRandomIntAnnotationBeanPostProcessor(){
        return new InjectRandomIntAnnotationBeanPostProcessor();
    }

    @Bean
    private Quoter quoter(){
        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setMessage("My first annotation!!!");
        return simpleObject;
    }
}
