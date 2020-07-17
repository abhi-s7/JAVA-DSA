package recursion;

public class RecursionBasics4Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fact(5));

	}
	
	
	static int fact(int num) {
		if(num == 1) {
			return 1;
		}
		
		return num*fact(num - 1);
		
		
	}	
	
/* ********************factorial using for loop *****************************

			static int fact(int num) {
					int f = 1;
					
					for(int i = num ; i>0 ; i--) {
						f = f*i;
					}
					
					return f;
				}
*/
	
	

}
