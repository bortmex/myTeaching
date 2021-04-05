package com.rog.teach.simpleExample.main2;

import com.rog.teach.thread.TaskWithResult;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 5; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs: results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                ExceptionUtils.printRootCauseStackTrace(e);
            } catch (ExecutionException e) {
                ExceptionUtils.printRootCauseStackTrace(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}
