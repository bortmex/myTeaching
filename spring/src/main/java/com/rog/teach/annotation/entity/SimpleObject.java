package com.rog.teach.annotation.entity;

import com.rog.teach.annotation.customAnnotation.DeprecatedClass;
import com.rog.teach.annotation.customAnnotation.InjectRandomInt;
import com.rog.teach.annotation.customAnnotation.PostProxy;
import com.rog.teach.annotation.customAnnotation.Profiling;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = SimpleObject2.class)
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
    //@PostConstruct метод запустится но изза отсутсвия на этом этапе прокси профелирования не будет
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
