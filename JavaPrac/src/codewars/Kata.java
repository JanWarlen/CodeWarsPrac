package codewars;

public class Kata {

	public static int getLengthOfMissingArray(Object[][] arrayOfArrays)
	{
		if(null == arrayOfArrays || 0 == arrayOfArrays.length){
			return 0;
		}
		int now = 0;
		int minLen = null==arrayOfArrays[0]?arrayOfArrays[0].length:0;
		for(int i = 0; i < arrayOfArrays.length; i++){
			if(null == arrayOfArrays[i] || 0 == arrayOfArrays[i].length){
				return 0;
			}
			now+=arrayOfArrays[i].length;
			minLen = minLen>arrayOfArrays[i].length?arrayOfArrays[i].length:minLen;
		}
		int exp = (arrayOfArrays.length-1)*arrayOfArrays.length/2 + arrayOfArrays.length*minLen;
		return arrayOfArrays.length+minLen+exp-now;
	}
	//[[3, 2, 2, 3], [1, 4, 4, 3, 4], [2, 2, 0, 3, 1, 2], [3, 2, 1, 2, 0, 1, 0, 0]] 
	
	public static int findEvenIndex(int[] arr) {
// your code
		for(int i = 0; i < arr.length; i++){
			int sum = 0;
			for(int j = 0; j < i; j++){
				sum+=arr[j];
			}
			for(int j = arr.length-1; j > i; j--){
				sum-=arr[j];
			}
			if(0 == sum){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Object[][] test = new Object[][] { };
		System.out.println(findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
	}
}
