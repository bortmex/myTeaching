package com.rog.teach.exampleTaskJavaRush.task0407;

import io.vavr.control.Try;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool(10);
        List<Future<String>> futureList = new ArrayList<>();
        Callable<String> callable = new MyCallable();
        for (int i = 0; i < 100; i++) {
            Future<String> submit = executorService.submit(callable);
            futureList.add(submit);
        }
        for (Future<String> fun : futureList) {
            Try.of(() -> LocalDateTime.now() + " " + fun.get())
                    .onSuccess(System.out::println)
                    .onFailure(exception -> {
                        //TODO do nothing;
                    }).get();
        }
        executorService.shutdown();
    }
}
