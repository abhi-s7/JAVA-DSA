package recursion;

public class SumOfDigits {
	
	//static int sum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(sum(123,0));

	}
	
	public static int sum(int num, int sum) {
		
		if(num == 0) {
			return sum;
		}
		
		
		sum += num % 10;
		num/=10;
			
		return sum(num,sum);
		
		
	}

}
