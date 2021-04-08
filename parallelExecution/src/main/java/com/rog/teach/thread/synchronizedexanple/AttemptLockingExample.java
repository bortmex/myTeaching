package com.rog.teach.thread.synchronizedexanple;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLockingExample {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("lock.tryLock(2, TimeUnit.SECONDS) : " + captured);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLockingExample a1 = new AttemptLockingExample();
        a1.untimed();
        a1.timed();

        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                a1.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        a1.untimed();
        a1.timed();
    }
}
