package com.rog.teach.annotation.config;

import com.rog.teach.annotation.screensaver.ColorFrame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com.rog.teach.annotation.screensaver")
public class Config {

    @Bean
    @Scope(value = "periodical")
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame frame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
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
