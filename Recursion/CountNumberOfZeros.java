package recursion;

public class CountNumberOfZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(noof_zeros(10002003,0));

	}
	
	static int noof_zeros(int num, int counter) {
		
		if (num == 0) {return counter;}
		
		
		if(num % 10 == 0) {counter++;}
		
		return noof_zeros(num/10, counter);
		
		
		
	}

}
