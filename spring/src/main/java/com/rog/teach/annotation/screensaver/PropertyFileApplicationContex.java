package com.rog.teach.annotation.screensaver;

import com.rog.teach.annotation.config.Config;
import com.rog.teach.annotation.entity.ColorFrame;
import com.rog.teach.annotation.entity.DontRun;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class PropertyFileApplicationContex extends GenericApplicationContext {

    public PropertyFileApplicationContex(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int i = reader.loadBeanDefinitions(fileName);
        System.out.println("found " + i + " beans");
        refresh();
    }

    public static void main(String[] args) throws InterruptedException {
        //PropertyFileApplicationContex context = new PropertyFileApplicationContex("context.properties");
        //context.getBean(Quoter.class).sayQuote();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(100);
        }
//        new Thread(new DontRun()).start();
//            new Thread(new DontRun()).start();
//            new Thread(new DontRun()).start();
//            new Thread(new DontRun()).start();


    }

}
