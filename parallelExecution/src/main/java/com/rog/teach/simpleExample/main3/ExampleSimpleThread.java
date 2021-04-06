package com.rog.teach.simpleExample.main3;

import com.rog.teach.thread.extThread.SimpleThread;

public class ExampleSimpleThread {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
