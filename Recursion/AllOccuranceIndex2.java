package recursion;

public class AllOccuranceIndex2 {
	
	public static void main(String args[]) {
		
		int[] arr = {10,20,10,90,10,100};
		int[] index = allOccurance(arr,10,0,0);
		
		for(int i : index) {
			System.out.print(i + " ");
		}
		
	}
	
	static int[] allOccurance(int arr[], int data, int index,int counter) {
		
		if(index == arr.length) {
			int a[] = new int[counter];
			return a;
		}
		
		int result[] = null;
		
		if(arr[index] == data) {
			result = allOccurance(arr,data,index + 1, counter + 1);
		}
		else {
			result = allOccurance(arr,data,index+1, counter);
		}
		
		if(arr[index] == data) {
			result[counter] = index;
			return result;
		}else {
			return result;
		}
		
	}

}
