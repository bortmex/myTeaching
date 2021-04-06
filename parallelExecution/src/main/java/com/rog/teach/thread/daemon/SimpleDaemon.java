package com.rog.teach.thread.daemon;

import java.util.concurrent.TimeUnit;

public class SimpleDaemon implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.print("sleep() interrupted");
        }
    }
}
