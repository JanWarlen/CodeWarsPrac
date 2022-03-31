import java.util.Arrays;

public class Kata {

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (null == arrayOfArrays || 0 == arrayOfArrays.length) {
            return 0;
        }
        int now = 0;
        int minLen = null == arrayOfArrays[0] ? arrayOfArrays[0].length : 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            if (null == arrayOfArrays[i] || 0 == arrayOfArrays[i].length) {
                return 0;
            }
            now += arrayOfArrays[i].length;
            minLen = minLen > arrayOfArrays[i].length ? arrayOfArrays[i].length : minLen;
        }
        int exp = (arrayOfArrays.length - 1) * arrayOfArrays.length / 2 + arrayOfArrays.length * minLen;
        return arrayOfArrays.length + minLen + exp - now;
    }
    //[[3, 2, 2, 3], [1, 4, 4, 3, 4], [2, 2, 0, 3, 1, 2], [3, 2, 1, 2, 0, 1, 0, 0]]

    public static int findEvenIndex(int[] arr) {
// your code
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }
            for (int j = arr.length - 1; j > i; j--) {
                sum -= arr[j];
            }
            if (0 == sum) {
                return i;
            }
        }
        return -1;
    }

    //---------------------------------------------------------------------
	/*Write a function that takes a positive integer and returns the next smaller positive integer containing the same digits.

	For example:

	nextSmaller(21) == 12
	nextSmaller(531) == 513
	nextSmaller(2071) == 2017
	Return -1, when there is no smaller number that contains the same digits. Also return -1 when the next smaller number with the same digits would require the leading digit to be zero.

	nextSmaller(9) == -1
	nextSmaller(111) == -1
	nextSmaller(135) == -1
	nextSmaller(1027) == -1 // 0721 is out since we don't write numbers with leading zeros
	some tests will include very large numbers.
	test data only employs positive integers.*/
    public static long nextSmaller(long n) {
        String nStr = new String(n + "");
        int nLen = nStr.length();
        int[] nArr = new int[nLen];
        for (int i = 0; i < nLen; i++) {
            nArr[i] = Integer.parseInt(nStr.charAt(i) + "");
        }
        boolean flag = true;
        for (int i = nLen - 1; i > -1 && flag; i--) {//
            int x = getBigestSmallerNumIndex(nArr, i);
            if (i != x && x > -1) {
                if (0 == nArr[x] && i == 0) {
                    continue;
                }
                int tmp = nArr[x];
                for (int j2 = x; j2 > i; j2--) {
                    nArr[j2] = nArr[j2 - 1];
                }
                nArr[i] = tmp;
                int[] B = Arrays.copyOfRange(nArr, i + 1, nLen);
                Arrays.sort(B);
                B = reverse(B);
                System.arraycopy(B, 0, nArr, i + 1, B.length);
                flag = false;
            }
        }

        long sum = -1;
        if (!flag) {
            sum = 0;
            for (int j = 0; j < nLen; j++) {
                long tmp = (long) (nArr[j] * Math.pow(10, nLen - j - 1));
                sum += tmp;
            }
        }

        return sum;
    }

    public static int getBigestSmallerNumIndex(int[] x, int i) {
        int tmp = x[i];
        int min = -1;
        int idx = -1;
        for (; i < x.length; i++) {
            if (x[i] < tmp && x[i] > min) {
                min = x[i];
                idx = i;
            }
        }
        return idx;
    }

    public static int[] reverse(int[] validData) {
        for (int i = 0; i < validData.length / 2; i++) {
            int temp = validData[i];
            validData[i] = validData[validData.length - i - 1];
            validData[validData.length - i - 1] = temp;
        }

        return validData;
    }
    //-----------------------------------------------------

    public static void main(String[] args) {
//		Object[][] test = new Object[][] { };
//		System.out.println(findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
        System.out.println(nextSmaller(197716517592670880L));
    }
}
