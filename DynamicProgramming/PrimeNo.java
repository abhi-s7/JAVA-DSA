package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class PrimeNo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//****************************DP Part************************************
		HashMap<Integer,Integer> cache = new HashMap<>();
		//****************************DP Part************************************
		 
		
		//to tell whether this number is prime or not
		//prime numbers are those that are not divisible by any other number
		try {
			while(true) {
				
				System.out.println("Enter the number: ");
				int number = scan.nextInt();
				
				//****************************DP Part************************************			
				if (cache.containsKey(number)) {
				//if (cache.get(number)!=null) {
					
					System.out.println("Cached Prime Number: " + number);
					continue;
				}
				//****************************DP Part************************************
	
				boolean isPrime = true;
				
				for(int i = 2; i< number ; i++) {
					
					if(number%i == 0) {
						System.out.println("Not Prime");
						isPrime = false;
						break;
					}
					
				}
				
				if(isPrime) {
					//****************************DP Part************************************
					cache.put(number,number);
					//****************************DP Part************************************
					
					System.out.println("Compute Prime Number: " + number);
				}
			}
		
		}
		
		finally {
			scan.close();
		}
			

	}

}
