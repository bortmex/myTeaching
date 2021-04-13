package com.rog.teach.simpleExample.main8;

import com.rog.teach.thread.MultiLock;

public class MultiLockExample {
    public static void main(String[] args) {
        final MultiLock multiLock = new MultiLock();
        new Thread(() -> multiLock.f1(10)).start();
    }
}
