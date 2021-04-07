package com.rog.teach.thread;

import java.io.IOException;

public class UnresponsiveUI extends Thread{
    private volatile  double d = 1;

    public UnresponsiveUI() throws IOException {
        start();
    }

    @Override
    public void run() {
        while (d > 0){
            d = d + (Math.PI + Math.E) / d;
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
