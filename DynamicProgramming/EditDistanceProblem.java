package DynamicProgramming;

/*
 * Given are two string 
 * We have given 3 operations
 * 1. Insert
 * 2. Delete
 * 3. Replace
 * 
 * Using these three operation calculate the minimum operations required 
 * to make them similar
 * 
 * String str1 = "Sunday" & str2 = "Saturday"
 * Length str1 = m & length str2 = n
 * "day" is same in both the string so remove it.
 * We are left with "Sun" and "Satur"
 * So three operation will be required to make them equal
 * 
 * :: Note - We have to tell the operations not that we have to show them how it becomes equal
 * Delete = fn(n-1, m)  // We are reducing one element from Str2
 * Insert = fn(m-1, n) // If one is constant and one str has reduced then we have high chances of gettin similar strings
 * Replace = fn(m-1, n-1)
 * Finally take the minimum value of all above operations
 * 
 * For every Insert, Delete, Replace operations there are again 3 further operations as it is recursion
 * 
 */

public class EditDistanceProblem {
	
	static int ed(String first, String second, int m, int n) {
		
		if(m==0) {
			return n; // i.e. we are left with n operations more
		}
		
		if(n==0) {
			return m;
		}
		
		if(first.charAt(m-1) == second.charAt(n-1)) {
			//i.e. both are same like we have "day" common in both the strings
			return ed(first, second, m-1, n-1);
		}
		
		// if first String is small
		int insert = ed(first, second, m, n-1); //m constant and delete from second therefore insert
		int delete = ed(first, second, m-1, n);
		
		// if first String is big
//		int delete = ed(first, second, m, n-1); 
//		int insert = ed(first, second, m-1, n);
		
		int replace = ed(first, second, m-1, n-1);
		
		//1+ because we have to count the operations
		return 1+ Math.min(insert,
				Math.min(delete, replace)); //extracting the minimum of all the three
	
	}
	
	public static void main(String[] args) {
		String first = "Sunday";
		String second = "Saturday";
		
		int opr = ed(first, second, first.length(), second.length());
		System.out.println(opr);
	}

}
