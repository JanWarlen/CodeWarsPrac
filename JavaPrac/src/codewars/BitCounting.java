package codewars;

public class BitCounting {

	public static int countBits(int n){
		String bin = Integer.toBinaryString(n);
		char[] chars = bin.toCharArray();
		int res = 0;
		for(int i = 0; i < chars.length; i++){
			if('1' == chars[i]){
				res++;
			}
		}
		
		return res;
	}
	
	
	
}
