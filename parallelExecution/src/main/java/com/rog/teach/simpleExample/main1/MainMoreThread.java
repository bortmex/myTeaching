package com.rog.teach.simpleExample.main1;

import com.rog.teach.thread.impRunnable.LiftOff;

public class MainMoreThread {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
