package codewars;

import java.util.Arrays;

public class AreSame {

	public static boolean comp(int[] a, int[] b) {
		if(null == a || null == b || (a.length != b.length)){
			return false;
		}
		if(0 == a.length || 0 == b.length){
			return true;
		}
		Arrays.sort(a);
		Arrays.sort(b);
		System.out.println(join(a));
		for(int i = 0; i < b.length; i++){
			if(a[i] != Math.sqrt(b[i])){
				return false;
			}
		}
		return true;
	}
	
	public static String join(int[] arr){
		// 定义一个字符串对象,内容为空  
        String s = "";  
  
        // 先把字符串拼接一个"["  
        s += "[";  
  
        // 编历int数组,得到每一个元素  
        for (int x = 0; x < arr.length; x++) {  
            if (x == arr.length - 1) {  
                s += arr[x];  
                s += "]";  
            } else {  
                s +=arr[x];  
                s+=", ";  
            }  
        }  
        return s;
	}
	
	
	public static void main(String[] args) {
		int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
		int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
		System.out.println(comp(a,b));
	}
}
