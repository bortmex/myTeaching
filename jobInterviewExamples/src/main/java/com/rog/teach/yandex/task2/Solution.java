package com.rog.teach.yandex.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        int size = Integer.parseInt(n);
        int index = 0;
        int result = 0;
        int finalResult = 0;
        while (index < size){
            index++;
            String s = br.readLine();
            int value = Integer.parseInt(s);
            if(value == 1){
                result++;
            } else {
                if(finalResult<result) {
                    finalResult = result;
                }
                result = 0;
            }
        }
        if(finalResult == 0 || result > finalResult){
            finalResult = result;
        }
        System.out.println(finalResult);
    }
}
