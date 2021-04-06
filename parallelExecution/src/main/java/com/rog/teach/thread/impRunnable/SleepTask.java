package com.rog.teach.thread.impRunnable;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.concurrent.TimeUnit;

public class SleepTask extends LiftOff {
    @Override
    public void run() {
        try {
            while (countDown-- > 0){
                status();
                TimeUnit.MICROSECONDS.sleep(1000);
            }
        } catch (InterruptedException e) {
            ExceptionUtils.printRootCauseStackTrace(e);
        }
    }
}
