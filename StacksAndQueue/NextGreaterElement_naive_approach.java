package stackANDqueue;

public class NextGreaterElement_naive_approach {
	
	//time complexity = N2

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {4,5,2,25};
		int NGE;
		
		for(int i = 0; i<arr.length; i++) {
			NGE = -1;
			for(int j = i+1; j<arr.length;j++) {
				
				if(arr[i] < arr[j]) {
//					System.out.println(arr[i]+ "-->" + arr[j]); //if done SOP here then we cannot print last element's NGE
														//therefore we'll have to maintain NGE initially
					NGE = arr[j];
					break;
				} //if ends
				
			} //inner loop ends
			
			System.out.println(arr[i] + "->" + NGE);
			
		}// outer loop ends

	}

}
