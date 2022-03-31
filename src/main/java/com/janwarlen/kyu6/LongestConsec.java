package com.janwarlen.kyu6;

// https://www.codewars.com/kata/56a5d994ac971f1ac500003e
public class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {
        // your code
        if (k <= 0 || strarr.length < k) {
            return "";
        }
        int maxLen = 0;
        int tmp = 0;
        StringBuffer tmpStr;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < strarr.length - k + 1; i++) {
            tmpStr = new StringBuffer();
            for (int j = i; j < i + k; j++) {
                tmp += strarr[j].length();
                tmpStr.append(strarr[j]);
            }
            if (maxLen < tmp) {
                maxLen = tmp;
                res = tmpStr;
            }
            tmp = 0;
        }
        return res.toString();
    }
}
