package com.janwarlen.kyu5;

// https://www.codewars.com/kata/5541f58a944b85ce6d00006a
public class ProdFib {

    public static int fibonacci(int n) {
        if ((n == 1) || (n == 2)) return 1;
        else return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static long[] productFib(long prod) {
        // your code
        long a = 0;
        long b = 1;
        long tmp = 0;
        while (a * b < prod) {
            tmp = a;
            a = b;
            b += tmp;
        }
        return new long[]{a, b, a * b == prod ? 1 : 0};
    }

    public static void main(String[] args) {
        System.out.println(productFib(4895));
    }
}
