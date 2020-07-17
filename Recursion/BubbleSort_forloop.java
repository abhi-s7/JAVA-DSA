package recursion;

public class BubbleSort_forloop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,3,1};
		
		int temp;
		
		int size = arr.length;
		
//		for(int i = arr.length-1; i>0;i--) {
//			
//			for(int j = 0; j<i; j++) {
		
		for(int i = 0; i<size-1;i++) {        //traversal loop
		
			for(int j = 0; j<size-1-i; j++) {
		
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
		}
		
		for(int k = 0;k<arr.length;k++) {
			System.out.print(arr[k] + " ");
		}

	}

}
