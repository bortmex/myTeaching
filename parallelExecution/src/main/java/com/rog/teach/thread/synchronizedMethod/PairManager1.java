package com.rog.teach.thread.synchronizedMethod;

public class PairManager1 extends PairSimpleClassManager {

    public synchronized void increment() {
        p.incrementX();;
        p.incrementY();
        store(getPair());
    }
}