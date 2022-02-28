package com.rog.teach.exampleTaskJavaRush.task0407;

import java.util.stream.IntStream;

public class Solution0407 {
    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 101).filter(value -> value % 3 != 0).sum());
    }
}
