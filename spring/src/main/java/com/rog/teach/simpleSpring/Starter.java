package com.rog.teach.simpleSpring;


import com.rog.teach.simpleSpring.config.LessonsConfiguration;
import com.rog.teach.simpleSpring.entity.BeanWithDependency;
import com.rog.teach.simpleSpring.service.GreetingService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Starter {

    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void main(String[] args) {
        logger.info("Start configuration...");

        ApplicationContext context = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        //AbstractApplicationContext context = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        GreetingService greetingService = context.getBean(GreetingService.class);
        BeanWithDependency withDependency = context.getBean(BeanWithDependency.class);
        logger.info(greetingService.sayGreeting());  // "Greeting, user!"
        logger.info(withDependency.printText());  // "Greeting, user!"
        //context.registerShutdownHook();
    }
}
