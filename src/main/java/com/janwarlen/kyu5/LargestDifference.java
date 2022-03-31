package com.janwarlen.kyu5;

import java.util.Arrays;

// https://www.codewars.com/kata/52503c77e5b972f21600000e
public class LargestDifference {
    public static int largestDifference(int[] data) {
        int[] len = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] <= data[j]) {
                    len[i] = j - i;
                }
            }
        }
        Arrays.sort(len);
        return len[len.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(largestDifference(new int[]{9, 4, 1, 10, 3, 4, 0, -1, -2}));
    }
}
