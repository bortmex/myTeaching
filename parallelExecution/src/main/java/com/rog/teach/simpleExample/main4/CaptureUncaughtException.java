package com.rog.teach.simpleExample.main4;

import com.rog.teach.thread.withError.ExceptionThread2;
import com.rog.teach.thread.withError.HandlerThreadFactory;
import com.rog.teach.thread.withError.MyUncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaptureUncaughtException {
    public static void main(String[] args) {
        //Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
