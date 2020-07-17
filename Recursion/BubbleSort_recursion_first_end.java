package recursion;

public class BubbleSort_recursion_first_end {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BubbleSort_recursion_first_end br = new BubbleSort_recursion_first_end();
		
		int arr[] = {7,4,1,3};
		int size = arr.length;
		
		br.bubble(arr, 0, size-1);
		
		for(int i = 0; i<arr.length;i++)
			System.out.print(arr[i] + " ");

	}
	
	private void bubble(int[] arr, int first, int end) {
		
		if(end == 0) {
			return;
			}
		
		if(first == end) {
			bubble(arr,0,end-1);
			return;
		}
		
			if(arr[first]>arr[first+1]) {
				
				int temp = arr[first];
				arr[first] = arr[first+1];
				arr[first+1] = temp;
				
			}
			
			System.out.println(end);
			
			bubble(arr,first+1,end);

	}

} 
