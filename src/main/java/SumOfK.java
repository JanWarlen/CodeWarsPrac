import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfK {

    static int max = 0;

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        // your code

        int len = ls.size();
        if (k > len) {
            return null;
        }

        for (int i = 0; i < len - k; i++) {
            int sum = ls.get(i);
            sum = sumNum(i + 1, len, k - 1, sum, ls, t);
        }
        return 0 == max ? null : max;
    }

    public static Integer sumNum(int x, int len, int k, int sum, List<Integer> ls, int t) {
        for (int i = x; i < len; i++) {
            int tmp = sum + ls.get(i);
            if (1 == k) {
                if (tmp > max && tmp <= t) {
                    max = tmp;
                }
            } else {
                tmp = sumNum(i + 1, len, k - 1, tmp, ls, t);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> ts = new ArrayList<Integer>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        System.out.println(chooseBestSum(230, 3, ts));
    }
}
