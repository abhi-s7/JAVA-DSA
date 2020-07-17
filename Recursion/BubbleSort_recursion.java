package recursion;

public class BubbleSort_recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BubbleSort_recursion br = new BubbleSort_recursion();
		
		int arr[] = {2,1,4,3};
		int size = arr.length;
		
		int sorted[] = br.bubble(arr, size-1);
		
		for(int i = 0; i<arr.length;i++)
			System.out.print(sorted[i] + " ");

	}
	
	private int[] bubble(int[] arr, int traversal) {
		
		if(traversal == 1) {return arr;}
		
		
		int temp = 0;
		for(int i = 0; i<traversal; i++) {
			if(arr[i]>arr[i+1]) {
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		
		return bubble(arr,traversal - 1);
		
		

	}

}
