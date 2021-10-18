package com.rog.teach.replaceMethod;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MethodReplaceDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:replaceMethod/context.xml");
        ctx.refresh();
        ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");

        System.out.println(replacementTarget.formatMessage("123"));
        System.out.println(standardTarget.formatMessage("123"));
    }
}
