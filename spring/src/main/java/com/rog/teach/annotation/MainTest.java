package com.rog.teach.annotation;

import com.rog.teach.annotation.entity.Quoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {

       ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
 //     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);
        context.getBean(Quoter.class).sayQuote();
//        while (true) {
//            Thread.sleep(100);
//            context.getBean(Quoter.class).sayQuote();
//        }

    }
}
