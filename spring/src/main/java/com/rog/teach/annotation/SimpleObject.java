package com.rog.teach.annotation;

import javax.annotation.PostConstruct;

@Profiling
public class SimpleObject implements Quoter{
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    public SimpleObject() {
        //призапуске переменная repeat тут будет 0, если объект то возможен NullPointer
        System.out.println("Phase 1");
        System.out.println(repeat);
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
