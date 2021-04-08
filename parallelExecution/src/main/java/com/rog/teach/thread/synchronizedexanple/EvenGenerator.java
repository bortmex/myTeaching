package com.rog.teach.thread.synchronizedexanple;

import com.rog.teach.thread.generate.IntGenerator;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }
}
