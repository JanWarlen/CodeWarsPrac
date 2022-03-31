package com.janwarlen.kyu5;

// https://www.codewars.com/kata/554f76dca89983cc400000bb
public class Dioph {
    public static String solEquaStr(long n) {
        // your code
        System.out.println(n);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int max = (int) Math.sqrt(n) + 1;
        for (int i = 1; i < max + 1; i++) {
            if (((n + i * i) % (2 * i)) == 0 && ((n - i * i) % (4 * i)) == 0) {
                if (sb.length() > 1) {
                    sb.append(", ");
                }
                sb.append("[").append((n + i * i) / (2 * i)).append(", ").append((n - i * i) / (4 * i)).append("]");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
