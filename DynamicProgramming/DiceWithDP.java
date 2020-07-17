package DynamicProgramming;

public class DiceWithDP {
	
	static int countWays(int currentValue, int endValue) {
		
		if(currentValue==endValue) {
			return 1; // positive base case
		}
		if(currentValue>endValue) {
			return 0;//negative base case
		}
		int count = 0;
		for(int dice =1; dice<=6 ; dice++) {
			count+=countWays(currentValue + dice, endValue);
		}
		
		return count;
	}
	
	
	static int countWaysDP(int currentValue, int endValue, int[] cache) {
		
		if(currentValue==endValue) {
			return 1; // positive base case
		}
		if(currentValue>endValue) {
			return 0;//negative base case
		}
		
		//****************************DP Part************************************			
		if(cache[currentValue] != 0) {
			return cache[currentValue];
		}
		//****************************DP Part************************************			

		
		int count = 0;
		for(int dice =1; dice<=6 ; dice++) {
			count+=countWaysDP(currentValue + dice, endValue,cache);
		}
		
		//****************************DP Part************************************			
		cache[currentValue] = count;
		//****************************DP Part************************************			

		
		return count;
	}

	public static void main(String[] args) {
		int number = 3;
		int cache[] = new int[number+1];
		
		long timeBefore = System.currentTimeMillis();
		
		int result = countWaysDP(0,number,cache);
		System.out.println("DP: " + result);
		
		long timeAfter = System.currentTimeMillis();
		
		System.out.println("DP time taken: " + (timeAfter - timeBefore) + "ms");
		
		System.out.println("********************************************************");
		
		timeBefore = System.currentTimeMillis();
		
		result = countWays(0,number);
		System.out.println("Without DP: " + result);
		
		timeAfter = System.currentTimeMillis();
		
		System.out.println("Time taken: " + (timeAfter - timeBefore) + "ms");

	}
}
