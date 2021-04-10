package com.rog.teach.thread.synchronizedMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PairSimpleClassManager {
    AtomicInteger checkCounter = new AtomicInteger();
    protected PairSimpleClass p = new PairSimpleClass();
    private List<PairSimpleClass> storage =
            Collections.synchronizedList(new ArrayList<PairSimpleClass>());

    public synchronized PairSimpleClass getPair() {
        return new PairSimpleClass(p.getX(), p.getY());
    }

    protected void store(PairSimpleClass p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ognore) {
        }
    }

    public abstract void increment();
}