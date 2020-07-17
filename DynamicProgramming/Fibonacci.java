package DynamicProgramming;

import java.math.BigInteger;

public class Fibonacci {
	
	/*
	 * Approach to use DP in this problem
	 * 1. Take a array of size of nth+1
	 * 2. Mark the result at the nth index of array
	 * 3. When encountered the same number then use this stored result from array
	 * 4. As the accessing any element from array is O(1) thus it is efficient for TC
	 */
	
	//****************************Without DP************************************
	static int fib(int nth) {
		if(nth == 0 || nth == 1) {
			return 1;
		}
		int first = fib(nth - 1);
		int second = fib(nth - 2);
		
		return first + second;
	}
	//****************************Without DP************************************
	
	//****************************With DP************************************
	static int fibDP(int nth, int[] cache) {
		//overflow happens at 47 i.e. it start giving negative result :: Use BigInteger
		if(nth == 0 || nth == 1) {
			return 1;
		}
		
		if(cache[nth] != 0) {
			return cache[nth];
		}
		int first = fibDP(nth - 1, cache);
		int second = fibDP(nth - 2, cache);
		int sum = first + second;
		//BigInteger sum = fibDP(nth - 1, cache).add(fibDP(nth - 2, cache));

		cache[nth] = sum;
		
		return sum;
	}
	//****************************With DP************************************
	
	//****************************With DP************************************
	//****************************Tabulation*********************************
	static int tabulatin(int nth) {
		
		//in this technique we will use the cached result to make the sum of current
		//works in iteration
		//bottoms up approach
		
		int cache [] = new int[nth+1];
		cache[0] = 1;
		cache[1] = 1;
		
		for(int i = 2; i<= nth; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		
		return cache[nth];
		
	}
	
	//****************************With DP************************************


	
	public static void main(String[] args) {
		int number = 50;
		int cache[] = new int[number+1];
		
		long timeBefore = System.currentTimeMillis();
		
		int result = fibDP(number,cache);
		System.out.println("DP Fib sum: " + result);
		
		long timeAfter = System.currentTimeMillis();
		
		System.out.println("DP time taken: " + (timeAfter - timeBefore));
		
		System.out.println("********************************************************");
		
		timeBefore = System.currentTimeMillis();
		
		result = fib(number);
		System.out.println("Without DP Fib sum: " + result);
		
		timeAfter = System.currentTimeMillis();
		
		System.out.println("Without DP time taken: " + (timeAfter - timeBefore));

	
	}

}
