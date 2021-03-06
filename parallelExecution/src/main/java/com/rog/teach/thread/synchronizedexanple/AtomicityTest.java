package com.rog.teach.thread.synchronizedexanple;

public class AtomicityTest implements Runnable {
    private int i = 0;
    public synchronized int getValue(){
        return i;
    }
    private synchronized void evenIncrement(){
        i++;
        i++;
    }
    public void run() {
        while (true){
            evenIncrement();
        }
    }
}
