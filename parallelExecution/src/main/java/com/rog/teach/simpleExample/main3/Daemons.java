package com.rog.teach.simpleExample.main3;

import com.rog.teach.thread.daemon.Daemon;

import java.util.concurrent.TimeUnit;

public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }
}
