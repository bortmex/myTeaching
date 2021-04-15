package com.rog.teach.thread.producerСonsumerQueue;

import com.rog.teach.thread.impRunnable.LiftOff;

import java.util.concurrent.BlockingQueue;

public class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }
    public void add(LiftOff lo){
        try {
            rockets.put(lo);
        }catch (InterruptedException e){
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        }catch (InterruptedException e){
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}
