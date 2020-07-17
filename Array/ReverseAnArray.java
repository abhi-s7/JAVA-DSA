package Array;

public class ReverseAnArray {

	//reverse an Array
	// [90,10,20,1,5] => [5,1,20,10,90]

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {90,10,20,1,5};
		reverse1(arr);
		
	}
	
	static void reverse1(int[] arr) {
		//TC - O(N/2)
		//SC - O(1)
		 		
		//two pointer approach using for loop
		
		int size = arr.length;
		int temp = 0;
		
		for(int i = 0, j = size-1 ; i<j ; i++, j--) {
			
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		}
		
		for(int show: arr) {
			System.out.print( show + " ");
		}
	}
	
	static void reverse2(int[] array) {
		//TC - O(N/2)
		//SC - O(1)
 		
		//two pointer approach using while
		
		int low = 0;
		int high = array.length - 1;
		int temp = 0;
		
		while(low<high) {
			//swapping
			temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			low++;
			high--;
		}
		
		System.out.print("[");
		for(int element : array) {
			System.out.print(element + ",");
		}
		System.out.print("]");
		
	}
	
	//reverse An Array Second Approach
	//TC - O(N)
	//SC - O(N)
	
	static void reverse3(int[] arr1) {
		int [] arr2 = new int[arr1.length];
		
		for(int i = arr1.length - 1; i>=0; i--) {
			arr2[arr1.length - 1 - i] = arr1[i];
		}
		
		System.out.print("[");
		for(int element : arr2) {
			System.out.print(element + " ");
		}
		System.out.print("]");
	}

}
