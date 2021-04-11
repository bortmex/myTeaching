package com.rog.teach.thread.synchronizedMethod;

public class PairChecker implements Runnable {
    private PairSimpleClassManager pm;

    public PairChecker(PairSimpleClassManager pm) {
        this.pm = pm;
    }

    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}
