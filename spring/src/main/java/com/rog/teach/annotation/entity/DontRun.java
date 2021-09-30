package com.rog.teach.annotation.entity;

import com.rog.teach.annotation.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DontRun implements Runnable{

    @Override
    public void run() {
        while (true) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            context.getBean(ColorFrame.class).showOnRandomPlace();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}