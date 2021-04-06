package com.rog.teach.simpleExample.main1;

import com.rog.teach.thread.impRunnable.LiftOff;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for LiftOff");
    }
}
