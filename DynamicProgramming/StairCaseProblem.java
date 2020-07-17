package DynamicProgramming;

public class StairCaseProblem {
	/*Problem Statement
	 * We can move either one step or two steps
	 * based on that we need to find out the number of possibilities to reach a certain stair
	 * To reach stair 2 we have two possibilities 1. {1,1} 2. {2}
	 * To reach stair 3 we have three possibilities 1.{1,1,1} 2.{1,2} 3.{2,1}
	 */
	
	static int climbRec(int n) {
		
		if(n == 1 || n == 0) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		
		int firstStair = climbRec(n-1);
		int secondStair = climbRec(n-2);
		
		return firstStair + secondStair;
		
	}
	
	//this is same as the fibonacci problem where we go either n-1 or n-2 down the graph
	//Current time complexity is 2^(Height of the tree)
	
	static int climbTabulation(int n) {
		
		int cache []= new int[n+1];
		cache[1] = 1; //possibility for the first stair
		cache[2] = 2; //possibility for the first stair 
		

		for(int i = 3; i<=n; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		
		return cache[n];
	}
	
	public static void main(String[] args) {
		//int result = climbRec(4);
		int tabResult = climbTabulation(4);
		System.out.println(tabResult);
		
	}

}
