package com.rog.teach.thread.synchronizedMethod;

public class  PairManager2 extends PairSimpleClassManager {
    public void increment() {
        PairSimpleClass temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}