package com.janwarlen.kyu5;

// https://www.codewars.com/kata/55c6126177c9441a570000cc
public class WeightSort {

    public static String orderWeight(String strng) {
        // your code
        if ("".equals(strng)) {
            return "";
        }

        String[] strs = strng.split(" ");
        long[] data = new long[strs.length];
        int[] weight = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            data[i] = Long.parseLong(strs[i]);
            weight[i] = getWeight(strs[i]);
        }

        return getOrderedList(data, weight);
    }

    public static int getWeight(String n) {
        char[] nums = n.toCharArray();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Integer.parseInt(nums[i] + "");
        }
        return sum;
    }

    public static String getOrderedList(long[] list, int[] weight) {
        int len = list.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (weight[j] > weight[j + 1]) {
                    weight[j] += weight[j + 1];
                    weight[j + 1] = weight[j] - weight[j + 1];
                    weight[j] -= weight[j + 1];

                    list[j] += list[j + 1];
                    list[j + 1] = list[j] - list[j + 1];
                    list[j] -= list[j + 1];
                } else if (weight[j] == weight[j + 1]) {
                    char[] num1 = String.valueOf(list[j]).toCharArray();
                    char[] num2 = String.valueOf(list[j + 1]).toCharArray();
                    int j2 = 0;
                    for (; j2 < num1.length && j2 < num2.length; j2++) {
                        if (num1[j2] > num2[j2]) {
                            list[j] += list[j + 1];
                            list[j + 1] = list[j] - list[j + 1];
                            list[j] -= list[j + 1];
                            break;
                        } else if (num1[j2] < num2[j2]) {
                            break;
                        }
                    }
                    if (j2 == num2.length && list[j] > list[j + 1]) {
                        list[j] += list[j + 1];
                        list[j + 1] = list[j] - list[j + 1];
                        list[j] -= list[j + 1];
                    }
                }
            }
        }

        return join(list, " ");
    }

    public static String join(long[] o, String flag) {
        StringBuffer str_buff = new StringBuffer();

        for (int i = 0, len = o.length; i < len; i++) {
            str_buff.append(String.valueOf(o[i]));
            if (i < len - 1) str_buff.append(flag);
        }

        return str_buff.toString();
    }
}
