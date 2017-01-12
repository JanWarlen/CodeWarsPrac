package codewars;

public class FindOutlier {

	public static int find(int[] integers){
		int oneCount = 0;
		int zeroCount = 0;
		int resOdd = 1;
		int resEven = 0;
		for(int i = 0; i < integers.length; i++){
			if(Integer.toBinaryString(integers[i]).endsWith("1")){
				oneCount++;
				resOdd = integers[i];
				if(zeroCount > 1){
					break;
				}
			}else{
				zeroCount++;
				resEven = integers[i];
				if(oneCount > 1){
					break;
				}
			}
		}
		
		return oneCount==1?resOdd:resEven;
	}
	
	public static void main(String[] args) {
		int[] exampleTest2 = {Integer.MAX_VALUE, 0, 1};
		System.out.println(find(exampleTest2));
	}
	
}
