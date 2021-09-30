package com.rog.teach.annotation.entity;

public class SimpleObject2 extends SimpleObject implements Quoter{
    @Override
    public void sayQuote() {
        System.out.println("I say new message!!!");
    }
}
