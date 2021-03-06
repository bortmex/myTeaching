package com.rog.teach.simpleExample.main9;

import com.rog.teach.thread.waitNotify.Car;
import com.rog.teach.thread.waitNotify.WaxOff;
import com.rog.teach.thread.waitNotify.WaxOn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
