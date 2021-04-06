package com.rog.teach.simpleExample.main3;

import com.rog.teach.thread.daemon.SimpleDaemon;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemon());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.print("All demons started");
        TimeUnit.MILLISECONDS.sleep(1);
    }
}
