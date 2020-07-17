package recursion;

public class LastOccuranceIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {20,10,50,40,10,30,10,20};
		System.out.println(lastIndex(arr,10,0));
		

	}
	
	public static int lastIndex(int arr[],int data, int index) {
		if(arr.length == index) {
			return -1;
		}
		
		int ans = lastIndex(arr,data, index + 1);
		
		if(arr[index] == data && ans == -1) {
			return index;
		}else
			return ans;
		

	}

}
