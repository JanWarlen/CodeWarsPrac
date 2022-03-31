package com.janwarlen.kyu6;

// https://www.codewars.com/kata/5679aa472b8f57fb8c000047
public class EqualSidesOfAnArray {
    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }
            for (int j = arr.length - 1; j > i; j--) {
                sum -= arr[j];
            }
            if (0 == sum) {
                return i;
            }
        }
        return -1;
    }
}
