package BackTracking;

public class Queen1D {
	
	public static void main(String[] args) {
		boolean[] cells = new boolean[4];
		queen(cells,0,2,"");
	}
	
	static void queen(boolean cells[],int noQueensPlacedTill, 
			int noOfQueens, String answer) {
		
		if(noQueensPlacedTill == noOfQueens) {
			System.out.println(answer);
			return;
			
		}
		
		for(int i = 0; i<cells.length; i++) {
			if(!cells[i]) {   //checking if cells value is false then setting it to true
				cells[i] = true;// queen 1 placed1
			
				queen(cells,noQueensPlacedTill + 1,noOfQueens,
					answer + "Q" + noQueensPlacedTill + 
					"C" + i + " ");
				cells[i] = false;// here we undo our changes
			
			} 
			
		}
		
	}

}
