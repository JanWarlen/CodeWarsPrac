package com.janwarlen.kyu4;

import java.util.regex.Pattern;

// https://www.codewars.com/kata/54de279df565808f8b00126a
public class BinaryRegexp {

    public static Pattern multipleOf3() {
        // Regular expression that matches binary inputs that are multiple of 3
        return Pattern.compile("^(0+|0*1((10*1)|(01*0))*10*)$");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            if (i % 3 == 0) {
                System.out.println(Integer.toBinaryString(i) + "--------------" + i);
            }
        }
    }

}
