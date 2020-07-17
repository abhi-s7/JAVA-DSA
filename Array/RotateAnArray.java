package Array;

public class RotateAnArray {
	
	static int[] array2 = {90,20,10,5,2,1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //int array[] = {90,20,10,5,2,1};
		 //rotate1(array, 2);
		 
		 int rotation = 2;
		 rotate2(0, rotation -1);
		 rotate2(rotation, array2.length-1);
		 rotate2(0, array2.length-1);
		 print();

	}
	
	//naive approach
	static void rotate1(int[] array, int rotation) {
		//TC O(MN) - as two loops
		
		for(int i = 0; i<rotation; i++) {
			
			int first = array[0];  //saving the first element to replace it with last
			for(int j = 1; j<array.length; j++) {
				array[j-1] = array[j]; //replacing current elements with previous i.e. shifting by one
			}
			array[array.length-1] = first;
			
		}
		
		for(int show:array) {
			System.out.print(show+" ");
		}
	}
	
	static void rotate2(int low, int high) {
		//TC - 

		int temp = 0;
		while(low<high) {
			temp = array2[low];
			array2[low] = array2[high];
			array2[high] = temp;
			low++;
			high--;
		}
		
	}
	
	static void print() {  //array2
		for(int show:array2) {  //static array
			System.out.print(show+" ");
		}
	}

}
