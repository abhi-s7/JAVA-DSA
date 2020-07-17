package recursion;

public class RecursionBasics5Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(5,3));

	}
	
	
	static int pow(int num, int pow) {
		if(pow == 0) {
			return 1;
		}
		
		return num*pow(num ,pow - 1);
		
		
	}	
}
