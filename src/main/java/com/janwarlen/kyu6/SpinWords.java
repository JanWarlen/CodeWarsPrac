package com.janwarlen.kyu6;

// https://www.codewars.com/kata/5264d2b162488dc400000001
public class SpinWords {

    public String spinWords(String sentence) {
        String[] strs = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            if (str.length() > 4) {
                res.append(reverseStr(str)).append(" ");
            } else {
                res.append(str).append(" ");
            }
        }

        return res.toString().trim();
    }

    public String reverseStr(String str) {
        return new StringBuffer(str).reverse().toString();
    }
}
