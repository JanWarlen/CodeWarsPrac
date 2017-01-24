package codewars;

import java.util.Arrays;

/*Description:

Summary: Write a function which takes an array data of numbers and returns the largest difference in indexes j - i such that data[i] <= data[j]

Long Description:

The largestDifference takes an array of numbers. That array is not sorted. Do not sort it or change the order of the elements in any way, or their values.

Consider all of the pairs of numbers in the array where the first one is less than or equal to the second one.

From these, find a pair where their positions in the array are farthest apart.

Return the difference between the indexes of the two array elements in this pair.

Example:

LargestDifference.largestDifference(new int[]{1,2,3}); //returns 2,
//because here j = 2 and i = 0 and 2 - 0 = 2
*/
public class LargestDifference {
	public static int largestDifference(int[] data) {
		int s = data.length;
        for (int l = s - 1; l > 0; l--) {
          for (int i = 0; i < s - l; i++) {
            if (data[i] <= data[i + l]) {
              return l;
            }
          }
        }
        return 0;
    }
	
	public static void main(String[] args) {
		System.out.println(largestDifference(new int[]{9,4,1,10,3,4,0,-1,-2}));
	}
}
