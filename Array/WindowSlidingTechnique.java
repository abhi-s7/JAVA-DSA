package Array;

public class WindowSlidingTechnique {
	//this technique will give result in TC: O(N)
	
	static int fixed(int windowSize) {
		//aim is to print maximum sum within sub-array of 3
		int arr [] = {3,10,2,1,5,6,2,1,9,7};
		int max = Integer.MIN_VALUE; //at first we'll take Min value so we can compare it with other sum and make them max 
		int windowRange = windowSize;
		int currentSum = 0;
		
		for(int i = 0; i<arr.length; i++) {
			currentSum += arr[i];
			
			if(i >= windowRange-1) { //we did -1 because array starts from 0th index and 2nd index means 3 index values it have covered
				max = Math.max(currentSum, max);
				//now we have to subtract the starting index value of sub-array and move our window
				currentSum = currentSum - arr[i - (windowRange - 1)];  //(i - windowRange - 1) will always give the starting index
			}
		}
		
		return max;
		
	}
	
	static void dynamic() {
		
		int arr [] = {3,10,2,1,5,6,2,1,9,7};
		int target = 7;
		int currentSum = 0;
		int minWindowSize = Integer.MAX_VALUE;
		int windowStart = 0;//this will used to remove the previous element from the sum
		
		for(int i = 0; i<arr.length; i++) {
			
			currentSum += arr[i];
			
			//this while loop will run one or two or max three times there fore this technique will be considered to be in O(N)
			while(currentSum >= target) {
				int currentWindowSize = i - windowStart + 1;
				minWindowSize = Math.min(minWindowSize, currentWindowSize);
				currentSum = currentSum - arr[windowStart];
				windowStart++;
			}
		}
		
		System.out.println("Min. Window size: " + minWindowSize);
		
	}

	public static void main(String[] args) {
		int max = fixed(4);
		System.out.println("Max sum is: " + max);

	}
}
