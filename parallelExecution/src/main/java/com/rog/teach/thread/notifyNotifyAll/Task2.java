package com.rog.teach.thread.notifyNotifyAll;

public class Task2 implements Runnable {
    public static Blocker blocker = new Blocker();
    @Override
    public void run() {
        blocker.waitingCall();
    }
}
