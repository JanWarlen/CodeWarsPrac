package codewars;

import java.math.BigDecimal;

/*zeros(12) = 2 # 1 * 2 * 3 .. 12 = 479001600 
that has 2 trailing zeros 4790016(00)*/

public class Solution {

	public static int zeros(int n) {
		// your beatiful code here
		if (n < 2) {
			return 0;
		}
		int count = 0;
		BigDecimal res = new BigDecimal(1);
		BigDecimal multiplicand = null;
		BigDecimal ten = new BigDecimal(10);
		for (int i = 1; i <= n; i++) {
			multiplicand = new BigDecimal(i);
			res = res.multiply(multiplicand);
			while (res.remainder(ten) != ten) {
				res = res.remainder(ten);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println("start");
		System.out.println("test=" + zeros(14));
	}
}
