package com.janwarlen.kyu7;

import java.util.Arrays;

// https://www.codewars.com/kata/5656b6906de340bd1b0000ac
public class TwoToOne {

    public static String longest(String s1, String s2) {
        char[] res = s1.concat(s2).replaceAll("(?s)(.)(?=.*\\1)", "").toCharArray();
        Arrays.sort(res);
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(longest("aretheyhere", "yestheyarehere"));
    }
}
