package Array;

public class ZigagArray {

	public static void main(String[] args) {
		// [a,b,c,d,e,f,g]
		// a<b>c<d>e<f>g
		int[] array = {4,3,2,8,6,7,1};
		
		int temp = 0;
		boolean flag = true;
		
		for(int i = 0; i<array.length-1; i++) {
			
			if(flag) { //this snippet will run for odd positions
				if(array[i] > array[i+1]) {
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}else {// this snippet will run for even positions
				if(array[i] < array[i+1]) {
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
			
			flag = !flag;  //this will make program run odd even
			
		}
		
		for(int show : array) {
			System.out.print(show + " ");
		}

	}

}
