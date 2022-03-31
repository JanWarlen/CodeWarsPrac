package com.janwarlen.kyu6;

// https://www.codewars.com/kata/526571aae218b8ee490006f4
public class BitCounting {

    public static int countBits(int n) {
        String bin = Integer.toBinaryString(n);
        char[] chars = bin.toCharArray();
        int res = 0;
        for (char aChar : chars) {
            if ('1' == aChar) {
                res++;
            }
        }

        return res;
    }


}
