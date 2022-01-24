package com.rog.teach.yandex.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String J = br.readLine();
        String S = br.readLine();
        long count = 0;
        for (int i = 0; i < J.length(); i++) {
            char charJ = J.charAt(i);
            for (int j = 0; j < S.length(); j++) {
                char charS = S.charAt(j);
                if(charS == charJ){
                    S = S.substring(0, j) + S.substring(j + 1);
                    j--;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
