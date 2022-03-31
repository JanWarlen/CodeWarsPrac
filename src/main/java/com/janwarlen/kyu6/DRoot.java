package com.janwarlen.kyu6;

// https://www.codewars.com/kata/541c8630095125aba6000c00
public class DRoot {

    public static int digital_root(int n) {
        // ...
        char[] chars = Integer.toString(n).toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum += Integer.parseInt(chars[i] + "");
        }
        if (sum > 9) {
            sum = digital_root(sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(digital_root(195));
    }

}
