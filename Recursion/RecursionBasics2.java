package recursion;

//************************* printing number from 1 to 10 i.e. Stack falling ********************

public class RecursionBasics2 {
	
	public static void main(String... args) {
		fun(3);
	}
	
	static int fun(int n) {
		
		if(n == 0) {
			return 0;
		}
		
		
		int find = fun(n-1);  //recursive call  -  head recursion
		
		System.out.println(n);
		
		return find;
		
	}

}
