package com.janwarlen.kyu5;

// https://www.codewars.com/kata/54d4c8b08776e4ad92000835
public class PerfectPower {

    public static int[] isPerfectPower(int n) {
        // ...
        if (2 > n) {
            return null;
        }
        int half = (int) Math.ceil(Math.sqrt(n));
        int i = 2;
        while (true) {
            if (Math.pow(half, i) == n) {
                return new int[]{half, i};
            } else if (Math.pow(half, i) > n) {
                half--;
            } else {
                i++;
            }
            if (1 == half) {
                return null;
            }
        }
    }


    public static void main(String[] args) {

    }
}
