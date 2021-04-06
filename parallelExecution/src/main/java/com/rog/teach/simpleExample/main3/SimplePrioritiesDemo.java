package com.rog.teach.simpleExample.main3;

import com.rog.teach.thread.impRunnable.SimplePriorities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePrioritiesDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
            exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        }
        exec.shutdown();
    }
}
