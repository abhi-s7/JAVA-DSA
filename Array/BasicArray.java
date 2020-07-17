package Array;

public class BasicArray {
	
	// 1. Homogeneous (Same type)
	// 2. Contiguous Memory
	// 3. Random Access - Base Address + index*size(4 bytes)
	
	/* 
	 * Time Complexity of CRUD operations in Array 
	 * 
	 * Insert at beginning - O(N) - as we will shift other elements N times
	 * Insert at middle - O(N) - same we have to shift other elements
	 * Insert at end - O(1)
	 * 
	 * Delete at end - O(1)
	 * Delete at middle - O(N)
	 * Delete at beginning - O(N)
	 * 
	 * Read data at any index - accessing at any index - O(1)
	 * 
	 * Creating array of N elements - O(N)
	 * 
	 * */
	
	public static void main(String[] args) {
		
		
		//allowed syntaxes
		int arr[] = new int[5];
		int [] arr2 = new int[5];
		int [] arr3 = {10,20,30,40,50};
		int [] arr4 = new int[] {10,20,30,40,50};   //do not mention size in int[]
	}
	
	
	

}
