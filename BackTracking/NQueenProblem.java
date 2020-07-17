package BackTracking;

/*
 * 1. Count number of queens placed
 * 2. Print positions in which queens are placed
 * 3. Print number of ways i.e. permutation of placing the queens
*/
public class NQueenProblem{
	
	static boolean isQueenPlace(boolean board[][], int row, int col) {
		// case1 : check above the column
		for(int i = row; i>=0;i--) {
			//checking above the current row. col will be constant
			if(board[i][col]) {
				return false;//i.e. we cannot place the queen
			}
		}
		// case2 : check left diagonal
		for(int i = row,j = col ; i>=0 && j>=0 ; i--,j--) {//checking boundary condition
			if(board[i][j]) {
				return false;
			}
		}
			
		// case3 : check right diagonal
		
		for(int i = row,j = col ; i>=0 && j<board.length ; i--,j++) {//here we will increase the column as we are going right
			if(board[i][j]) {
				return false;
			}
		}
		return true;
	}
	
	static int getCount(boolean board[][]) {
		
		//we also have to maintain the counter to count the number of queens that are placed
		int countQueen = 0;
		
		for(int row = 0; row<board.length; row++) {// traversing the row from 0 to boardlength i.e. 4
			for(int col = 0; col<board[row].length; col++) {
				if(board[row][col]) {
					System.out.print(board[row][col] + "\t" + row + col);
					countQueen++;
				}
			}
			System.out.println();
		}
		
		return countQueen;
		
	}
	
	//during stack building it will place the queen
	//during stack falling it will un-place the queen and new possibility gets genereated
	//therefore when we place the queen at last row then print the row
	static void queenPermutation(boolean board[][], int currentRow){
		
		if(currentRow == board.length) {// i.e. current row exceeds the board as row starts from 0
			System.out.println("Total queens placed are: " + getCount(board));
			return;
		}
		
		
		//we are traversing the column & board[currentRow].length will give the length of column at currentRow
		for(int col = 0; col < board[currentRow].length; col++) {
			
			if(isQueenPlace(board,currentRow,col)) {
				board[currentRow][col] = true;
				
				queenPermutation(board,currentRow+1); // making recursive call
				//after fall
				board[currentRow][col] = false;
			}
			
			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean board[][] = new boolean[4][4];
		queenPermutation(board,0);
		

	}

}
