package Array;

public class SortArrayByParity {
	
	
	public static void main(String[] args) {
		
		int[] array = {2,6,1,8,5,9,3,4,7};
		//towPointerApproach(array);
		recursion(array,0);
		
	}
	
	static void towPointerApproach(int[] array) {

		int i = 0;
		int j = array.length -1;
		
		while(i<j) {
			
			if(array[i] % 2 == 0) { //if even
				i++;
			}else {
				if(array[j] % 2 != 0) { // if j is odd then we have to increment
					j--;
				}else {
					int temp = 0;
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					i++;
					j--;
				}
			}
			
		}
		
		for(int show: array) {
			System.out.print(show + " ");
		}
	}
	
	static void recursion(int[] array, int inc) {
		
		if(inc == array.length) {
			return;
		}
		
		int number = array[inc];
		
//		if(number % 2 == 0) {
//			inc++;
//			System.out.print(number+ " ");
//			recursion(array, inc);
//		}else {
//			inc++;
//			recursion(array, inc);
//			System.out.print(number + " ");
//		}
		
		if(number%2 == 0) {
			System.out.print(number + " ");
		}
		
		recursion(array, ++inc);
		
		if(number%2 != 0) {
			System.out.print(number + " ");
		}
		
	}

}
