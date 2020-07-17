package DynamicProgramming;

/*Problem Statement
 * Compare two String and find out the longest of the common subsequence
 * eg. String str1 = "ABCDGH"
 * String str2 = "AEDFHR"
 * Subsequence: A, AD, AH, ADH
 * Therefore the LCS is ADH
 * 
 * This technique is generally used to check plagarism
 */

/*
 * Pass both the string in the function with their length - 1
 * Start comparing the last element of both the strings.
 * If it matches then count++
 * if not then make call for m-1 and second n-1
 * 
 * We can also do that by starting then we don't have to maintain m and n.
 * Base case = when the str.length() == 0
 */

public class LongestCommonSubSequence {
	
	static int lcs(String first , String second) {
		if(first.length() == 0 || second.length() == 0) {
			return 0;
		}
		int count = 0;
		if(first.charAt(0) == second.charAt(0)) {
			//both the characters matched hence we'll remove them and pass the remaining string for the next call
			count = 1 + lcs(first.substring(1), second.substring(1));
		}
		else {
			//we have to make two seperate calls 
			//1st when first.substring(1) and second as it is
			//2nd vice versa
			int result1 = lcs(first.substring(1),second);
			int result2 = lcs(first,second.substring(1));
			count = Math.max(result1, result2);//we have to consider the max count
		}
		
		return count;
			
	}
	
	static int lcsDP(String first , String second,int initFirst, int initSecond, int cache[][]) {
		if(first.length() == 0 || second.length() == 0) {
			return 0;
		}
		
		if(cache[initFirst - first.length()][initSecond - second.length()] != 0) {
			return cache[first.length()	][second.length()];
		}
		int count = 0;
		if(first.charAt(0) == second.charAt(0)) {
			//both the characters matched hence we'll remove them and pass the remaining string for the next call
			count = 1 + lcs(first.substring(1), second.substring(1));
		}
		else {
			//we have to make two seperate calls 
			//1st when first.substring(1) and second as it is
			//2nd vice versa
			int result1 = lcs(first.substring(1),second);
			int result2 = lcs(first,second.substring(1));
			count = Math.max(result1, result2);//we have to consider the max count
		}
		
		cache[initFirst - first.length()][initSecond - second.length()] = count;
		
		return count;
			
	}
	
	public static void main(String[] args) {
		
		String first = "abcdu";
		String second = "acbd";
		
//		int result = lcs("agggh","agh");
		int result = lcs(first,second);
		System.out.println(result);
		
		
//		int cache[][] = new int [6][4];
//		int resultDP = lcsDP("agggh","agh",5,3,cache);
		int cache[][] = new int [first.length()+1][second.length()+1];
		int resultDP = lcsDP(first,second,first.length(),second.length(),cache);
		System.out.println(resultDP);
		
	}

}
