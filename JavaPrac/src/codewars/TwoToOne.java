package codewars;

import java.util.Arrays;

public class TwoToOne {

	public static String longest (String s1, String s2) {
		char[] res = s1.concat(s2).replaceAll("(?s)(.)(?=.*\\1)", "").toCharArray();
		Arrays.sort(res);
		return String.valueOf(res);
    }
	
	public static void main(String[] args) {
		System.out.println(longest("aretheyhere", "yestheyarehere"));
	}
}
