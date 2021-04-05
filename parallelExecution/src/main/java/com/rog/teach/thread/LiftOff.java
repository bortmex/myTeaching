package com.rog.teach.thread;

public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public void status(){
        System.out.println("#" + id + " (" + (countDown > 0 ? countDown : "Liftoff!") + ")");
    }
    public void run() {
        while (countDown-- > 0) {
            status();
        }
    }
}
