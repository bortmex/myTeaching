package com.rog.teach.simpleExample.main4;

import com.rog.teach.thread.sleepAndJoin.Joiner;
import com.rog.teach.thread.sleepAndJoin.Sleeper;

public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);
        Joiner dopey = new Joiner("Dopey", sleepy);
        Joiner doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}
