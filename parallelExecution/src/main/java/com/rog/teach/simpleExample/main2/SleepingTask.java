package com.rog.teach.simpleExample.main2;

import com.rog.teach.thread.SleepTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SleepingTask {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepTask());
        }
        exec.shutdown();
    }
}
