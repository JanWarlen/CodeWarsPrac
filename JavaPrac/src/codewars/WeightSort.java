package codewars;

/*My friend John and I are members of the "Fat to Fit Club (FFC)". John is worried because each month a list with the weights of members is published and each month he is the last on the list which means he is the heaviest.

I am the one who establishes the list so I told him: "Don't worry any more, I will modify the order of the list". It was decided to attribute a "weight" to numbers. The weight of a number will be from now on the sum of its digits.

For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99. Given a string with the weights of FFC members in normal order can you give this string ordered by "weights" of these numbers?

Example:

"56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes: "100 180 90 56 65 74 68 86 99"

When two numbers have the same "weight", let us class them as if they were strings and not numbers: 100 is before 180 because its "weight" (1) is less than the one of 180 (9) and 180 is before 90 since, having the same "weight" (9) it comes before as a string.

All numbers in the list are positive numbers and the list can be empty.*/
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
		
		return getOrderedList(data,weight);
	}
	
	public static int getWeight(String n){
		char[] nums = n.toCharArray();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += Integer.parseInt(nums[i]+"");
		}
		return sum;
	}
	
	public static String getOrderedList(long[] list,int[] weight){
		int len = list.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len-1; j++) {
				if(weight[j] > weight[j+1]){
					weight[j] += weight[j+1];
					weight[j+1] = weight[j] - weight[j+1];
					weight[j] -= weight[j+1];
					
					list[j] += list[j+1];
					list[j+1] = list[j] - list[j+1];
					list[j] -= list[j+1];
				}else if(weight[j] == weight[j+1]){
					char[] num1 = String.valueOf(list[j]).toCharArray();
					char[] num2 = String.valueOf(list[j+1]).toCharArray();
					int j2 = 0;
					for (; j2 < num1.length && j2 < num2.length; j2++) {
						if(num1[j2] > num2[j2]){
							list[j] += list[j+1];
							list[j+1] = list[j] - list[j+1];
							list[j] -= list[j+1];
							break;
						}else if(num1[j2] < num2[j2] ){
							break;
						}
					}
					if (j2 == num2.length && list[j] > list[j+1]) {
						list[j] += list[j+1];
						list[j+1] = list[j] - list[j+1];
						list[j] -= list[j+1];
					}
				}
			}
		}
		
		return join(list," ");
	}
	
	public static String join( long[] o , String flag ){
	    StringBuffer str_buff = new StringBuffer();
	  
	    for(int i=0 , len=o.length ; i<len ; i++){
	        str_buff.append( String.valueOf( o[i] ) );
	        if(i<len-1)str_buff.append( flag );
	    }
	 
	    return str_buff.toString(); 
	}
	
	//best answer
/*	public static String orderWeight(String string) {
		String[] split = string.split(" ");
		Arrays.sort(split, new Comparator<String>() {
			public int compare(String a, String b) {
				int aWeight = a.chars().map(c -> Character.getNumericValue(c)).sum();
				int bWeight = b.chars().map(c -> Character.getNumericValue(c)).sum();
				return aWeight - bWeight != 0 ? aWeight - bWeight : a.compareTo(b);
			}
		});
		return String.join(" ", split);
	}*/
	
	public static void main(String[] args) {
		System.out.println(orderWeight("71899703 200 6 91 425 4 67407 7 96488 6 4 2 7 31064 9 7920 1 34608557 27 72 18 81"));
	}
}
