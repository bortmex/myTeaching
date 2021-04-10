package com.rog.teach.simpleExample.main6;

import com.rog.teach.thread.DualSynch;

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread(){
            @Override
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }
}
