package com.rog.teach.annotation.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configurable
@ComponentScan(basePackages = "com.rog.teach.annotation.entity")
public class Config {

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    private Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

//
//    @Bean
//    private InjectRandomIntAnnotationBeanPostProcessor injectRandomIntAnnotationBeanPostProcessor(){
//        return new InjectRandomIntAnnotationBeanPostProcessor();
//    }
//
//    @Bean
//    private SimpleObject simpleObject(){
//        SimpleObject simpleObject = new SimpleObject();
//        simpleObject.setMessage("My first annotation!!!");
//        return simpleObject;
//    }
//
//    @Bean
//    private ProfilingHandlerBeanPostProcessor profilingHandlerBeanPostProcessor() throws Exception {
//        return new ProfilingHandlerBeanPostProcessor();
//    }
//
//    @Bean
//    private PostProxyInvokerContextListener postProxyInvokerContextLister() {
//        return new PostProxyInvokerContextListener();
//    }
}
