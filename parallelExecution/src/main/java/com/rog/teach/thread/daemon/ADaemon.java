package com.rog.teach.thread.daemon;

import java.util.concurrent.TimeUnit;

public class ADaemon implements Runnable {
    public void run() {
        try {
            System.out.println("Start ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println("This should always run?");
        }
    }
}
