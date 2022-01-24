package com.rog.teach.yandex.task3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TODO решение не верное, надо через BufferedWriter...
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> sets = new LinkedList<>();
        String n = br.readLine();
        int size = Integer.parseInt(n);
        Integer lastValue = null;
        Integer currentValue;
        int index = 0;
        while (index < size){
            index++;
            String s = br.readLine();
            currentValue = Integer.parseInt(s);
            if(!currentValue.equals(lastValue)) {
                sets.add(currentValue);
            }
            lastValue = currentValue;
        }
        for (Integer value:sets) {
            System.out.println(value);
        }
    }
}
