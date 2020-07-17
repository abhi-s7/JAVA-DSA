package recursion;

public class AllOccuranceIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {10,20,10,90,10,100};
		int[] arr2 = allOccurance(arr,10,0);
		
		for (int i = 0; i<arr2.length; i++) {
			if(arr2[i] == 1) {
				System.out.print(i + " ");
			}
		}
		
		

	}
	
	static int[] allOccurance(int arr[], int data, int index) {
		
		if(index == arr.length) {
			return new int[arr.length];
		}
				
		//int[] ans = new int[arr.length];
		
		int[] ans = allOccurance(arr,data,index+1);
		
		if(arr[index] == data) {
			ans[index] = 1;
			return ans;
		}else {
			return ans;
		}
		
	}

}
