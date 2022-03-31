package com.janwarlen.kyu6;

// https://www.codewars.com/kata/57b6f5aadb5b3d0ae3000611
public class LengthOfMissingArray {

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (null == arrayOfArrays || 0 == arrayOfArrays.length) {
            return 0;
        }
        int now = 0;
        int minLen = null != arrayOfArrays[0] ? arrayOfArrays[0].length : 0;
        for (Object[] arrayOfArray : arrayOfArrays) {
            if (null == arrayOfArray || 0 == arrayOfArray.length) {
                return 0;
            }
            now += arrayOfArray.length;
            minLen = Math.min(minLen, arrayOfArray.length);
        }
        int exp = (arrayOfArrays.length - 1) * arrayOfArrays.length / 2 + arrayOfArrays.length * minLen;
        return arrayOfArrays.length + minLen + exp - now;
    }

}
