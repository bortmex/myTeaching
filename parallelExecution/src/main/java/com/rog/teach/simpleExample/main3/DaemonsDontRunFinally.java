package com.rog.teach.simpleExample.main3;

import com.rog.teach.thread.daemon.ADaemon;

import java.util.concurrent.TimeUnit;

public class DaemonsDontRunFinally {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
