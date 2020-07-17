package Array;

/*
 * Prefix sum is a technique to print the sum of a sub array
 * lets up suppose 0-4
 * For single request or query TC will be O(N)
 * But when multiple queries occur the TC becomes O(N^2) as we have to make N computation and every computation takes O(N)
 * Algo: 
 * 		1. Leave the first element as it if
 * 		2. Loop from 1 to array.length-1
 * 		3. For every element add it with the previous element
 * 		4. This way we'll get the sum of elements up to that particular index
 */

public class PrefixSum {
	
	static int[] prefix() {
		int arr[] = {9,8,1,2,3,6,4};
		for(int i = 1; i<arr.length; i++) {
			arr[i] = arr[i] + arr[i-1];
			
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int e[] = prefix();
		
		//to print range from 0-4
		
		System.out.println("Sum of range 0 to 4 is: " + e[4]);
	}

}
