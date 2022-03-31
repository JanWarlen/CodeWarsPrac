package com.janwarlen.kyu6;

// https://www.codewars.com/kata/5526fc09a1bbd946250002dc
public class FindOutlier {

    public static int find(int[] integers) {
        int oneCount = 0;
        int zeroCount = 0;
        int resOdd = 1;
        int resEven = 0;
        for (int integer : integers) {
            if (Integer.toBinaryString(integer).endsWith("1")) {
                oneCount++;
                resOdd = integer;
                if (zeroCount > 1) {
                    break;
                }
            } else {
                zeroCount++;
                resEven = integer;
                if (oneCount > 1) {
                    break;
                }
            }
        }

        return oneCount == 1 ? resOdd : resEven;
    }

    public static void main(String[] args) {
        int[] exampleTest2 = {Integer.MAX_VALUE, 0, 1};
        System.out.println(find(exampleTest2));
    }

}
