package com.rog.teach.thread.daemon;

public class DaemonSpawn implements Runnable {
    public void run() {
        while (true){
            Thread.yield();
        }
    }
}
