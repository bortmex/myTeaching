package com.rog.teach.simpleExample.main8;

import com.rog.teach.thread.blockMutex.Blocked2;
import com.rog.teach.thread.blockMutex.Blocked3;

import java.util.concurrent.TimeUnit;

public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        if(args.length != 1){
            System.out.println("usage: java InterruptingIdiom delay-in-mS");
            System.exit(1);
        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();
    }
}
