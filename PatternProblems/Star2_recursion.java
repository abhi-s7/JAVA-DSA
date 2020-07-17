package PatternProblems;

public class Star2_recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		star(5,1,5);

	}
	
	static void star(int num, int row, int col) {
		
		if(row>num) {
			return;
		}
		
		
		if(col<row) {
			System.out.println();
			star(num, ++row,5);
			return;
		}
		
		System.out.print("*");
		star(num, row, --col);
		
		
	}

}
