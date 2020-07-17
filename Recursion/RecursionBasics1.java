package recursion;

//printing numbers from 10 to 1 i.e. stack building

public class RecursionBasics1 {
	
	public static void main(String... args) {
		stack_building(3);
	}
	
	static void stack_building(int n) {
		
		if(n == 0) {
			return;
		}
		
		System.out.println(n);
		
		stack_building(n-1);  //recursive call - tail recursion as pre-processing
		
		
	}

}
