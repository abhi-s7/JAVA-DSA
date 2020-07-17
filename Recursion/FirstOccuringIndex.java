package recursion;

public class FirstOccuringIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {20,10,50,40,10,30};
		System.out.println(firstIndex(arr,10,0));
		

	}
	
	public static int firstIndex(int arr[],int data, int index) {
		if(arr.length == index) {
			return -1;
		}
		
		if(arr[index] == data) {
			return index;
		}
		else {
			int ans = firstIndex(arr,data, index + 1);
			return ans;
		}
	}

}
