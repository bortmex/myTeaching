package com.rog.teach.simpleExample.main5;

import com.rog.teach.simpleExample.main4.EvenChecker;
import com.rog.teach.thread.synchronizedexanple.MutexEvenGenerator;

public class MutexEvenGerator {
    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
