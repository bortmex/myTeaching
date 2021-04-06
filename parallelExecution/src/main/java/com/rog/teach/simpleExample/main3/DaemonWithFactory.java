package com.rog.teach.simpleExample.main3;

import com.rog.teach.thread.daemon.DaemonFromFactory;
import com.rog.teach.thread.daemon.DaemonThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonWithFactory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
            System.out.println("All daemons started");
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }
}
