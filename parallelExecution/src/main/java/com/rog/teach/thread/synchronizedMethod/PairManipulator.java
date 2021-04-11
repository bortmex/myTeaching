package com.rog.teach.thread.synchronizedMethod;

public class PairManipulator implements Runnable {
    private PairSimpleClassManager pm;

    public PairManipulator(PairSimpleClassManager pm) {
        this.pm = pm;
    }

    public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() +
                " checkCounter = " + pm.checkCounter.get();
    }
}
