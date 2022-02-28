package com.rog.teach.exampleTaskJavaRush.task0407;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(250);
        return Thread.currentThread().getName();
    }
}
