package PatternProblems;

public class Star3 {

	public static void main(String[] args) {
		
		int num = 5;

		for(int i = 1; i<=num; i++) {
			for(int j = 1 ; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = num-1; i>=1; i--) {
			for(int j = 1 ; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
