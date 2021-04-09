package com.rog.teach.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable{
    private AtomicInteger i = new AtomicInteger(0);
    public int getValue() {
        return i.get();
    }
    private void evenIncrement(){
        i.addAndGet(2);
    }
    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }
}
