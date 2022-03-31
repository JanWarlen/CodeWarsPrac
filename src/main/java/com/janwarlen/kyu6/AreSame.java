package com.janwarlen.kyu6;

import java.util.Arrays;

// https://www.codewars.com/kata/550498447451fbbd7600041c
public class AreSame {

    public static boolean comp(int[] a, int[] b) {

        if (null == a || null == b || (a.length != b.length)) {
            return false;
        }

        a = abs(a);
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < b.length; i++) {
            if (a[i] != (int) Math.sqrt(b[i])) {
                return false;
            }
        }
        return true;
    }


    public static int[] abs(int[] arr) {

        for (int x = 0; x < arr.length; x++) {
            arr[x] = Math.abs(arr[x]);
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(comp(a, b));
    }
}
