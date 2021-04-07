package com.rog.teach.thread.withError;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("we have caught " + e);
    }
}
