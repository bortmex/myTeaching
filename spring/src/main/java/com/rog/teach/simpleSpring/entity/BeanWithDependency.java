package com.rog.teach.simpleSpring.entity;

public class BeanWithDependency {

    private String text;

    public String printText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
