package PatternProblems;

public class Star3_Recursion {

	public static void main(String[] args) {
		star(3,1,1);

	}
	
	static void star(int num, int row, int col) {
		
		if(row>num) {
			return;
		}
		
		if(col>row) {
			System.out.println();
			star(num, ++row, 1);
			System.out.println();
			return;
		}
		
		System.out.print("*");
		
		star(num,row,++col);
		
		System.out.println("col: " + col);
		
//		while(row>0) {
//			System.out.print("*");
//			row--;
//		}
		
	}

}
