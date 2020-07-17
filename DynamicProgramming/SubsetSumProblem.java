package DynamicProgramming;

/*
 * Problem: Given an array {2,1,3,5} find out the that sub parts of that array forms a given sum. Let's say sum = 4
 * So the subset is {1,3}
 * 
 * Approach:
 * 	1. Start from end
 * 	2. If the element at current index is greater(>) than the sum then exclude by making recursive call and passing (m-1)
 * 	3. Now from the left array i.e. {2,1,3} , 3 is smaller than the sum
 * 		a. Exclude 3 from the sum and make recursive call
 * 		b. Include 3 in the sum and subtract it. i.e. sum - array[i] => 4-3
 */

public class SubsetSumProblem {
	
	static boolean subsetRecursion(int [] array, int m, int sum) {
		//Reach to the end of the sum(SubsetExist)
		if(sum == 0) {
			return true; //i.e. we have find the sum 
		}
		//M ends and still sum>0 so not Subset Sum
		if(m == 0 && sum>0) {
			return false; //i.e. when all the elements of the array have been used and still the sum is left
		}
		//When the element is greater than the sum
		if(array[m-1] > sum) {
			return subsetRecursion(array, m-1, sum);
		}
		
		return subsetRecursion(array, m-1, sum) || //i.e. when we are not including the element in the sum
			subsetRecursion(array, m-1, sum - array[m-1]); //the case when we subtract from the sum
		
	}
	
	static boolean subsetDP(int []set, int N, int Sum) {
		
		boolean subset[][] = new boolean[N+1][Sum+1];
		
		//If sum is 0 , then it is true for all the n values
		for(int i=0; i<=N; i++)
			subset[i][0] = true;
		
		//If sum is not 0 and set is empty(meaning n = 0,
		//then answer is false
		for(int i = 1; i<=Sum; i++)
			subset[0][i] = false;
		
		//Fill the subset in bottom up manner
		for(int row = 1; row<=N ; row++) {
			for(int sum = 1; sum<= Sum; sum++) {
				//Column( Sum value is smaller then the current value in the set)
				if(sum < set[row-1])
					subset[row][sum] = subset[row-1][sum]; //carry the previous row value
				//Column( sum value is greater than the current value in the set)
				else if( sum>= set[row-1]) {
					subset[row][sum] = subset[row-1][sum] || 
							subset[row-1][sum - set[row-1]];
				}
			}
		}
		
		for(int row = 0; row<=N ; row++) {
			for(int sum = 0; sum<= Sum; sum++) {
				boolean result = subset[row][sum];
				System.out.print(result?"T ":"F ");
			}
			System.out.println();
		}
		
		return subset[N][Sum];
		
	}
	
	public static void main(String[] args) {
		int set[] = {2,1,3,5};
		int sum = 4;
//		boolean result = subsetRecursion(set, set.length, sum);
		boolean result = subsetDP(set, set.length, sum);
		System.out.println(result?"Found":"Not Found");
	}

}
