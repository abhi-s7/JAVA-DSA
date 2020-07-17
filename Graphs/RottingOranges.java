package Graphs;

import java.util.LinkedList;

//we have to maintain the queue which will hold the rotten oranges location
class RPair{
	int row; 
	int col;
	RPair(int row, int col){
		this.row = row;
		this.col = col;
	}
}

public class RottingOranges {
	
	public static int orangesRotting(int[][] grid) {
		
		int timeTaken = -1;
		
		int rows = grid.length;
		int cols = grid[0].length;
		int freshOranges = 0;
		LinkedList<RPair> queue = new LinkedList<>();
		for(int i = 0; i<rows; i++) {
			for(int j = 0; j<cols;j++) {
				//storing rotten oranges in queue
				if(grid[i][j] == 2) {
					queue.addLast(new RPair(i,j));
				}
				else if(grid[i][j] == 1) {
					freshOranges++;
				}
			}
		}
		
		//directions array
//		int up[] = {0,1};
//		int down[] = {0,-1};
//		int right[] = {1,0};
//		int left[] = {-1,0}; //wrong as we have to think in form of matrix not 2d graph
		
		int up[] = {-1,0}; //as for up and down column is constant and row will change
		int down[] = {1,0};
		int right[] = {0,1};//row constant column will change
		int left[] = {0,-1};
		int directions[][] = {up,down,left, right};
		//adding the delimiter so as to count the time frames
		queue.addLast(new RPair(-1,-1));
		
		while(!queue.isEmpty()) {
			RPair pair = queue.removeFirst();//we will get the location of rotten orange
			
			if(pair.row == -1 && pair.col == -1) {
				timeTaken++;
				//and after removing that if still we encounter childs in queue then add the delimiter to last of the queue
				if(!queue.isEmpty()) {
					queue.addLast(new RPair(-1,-1));
				}
			}
			
			
			
			for(int direction = 0; direction<directions.length; direction++) {
				
				int neighbourRow = pair.row + directions[direction][0]; //adding the row of pair and row of direction from up/down/right/left
				int neighbourCol = pair.col + directions[direction][1];
				
				//boundary conditions
				//neighbourRow or Col should be within the grid length and should not be negative
				if( (rows > neighbourRow && neighbourRow >=0) &&
						(cols > neighbourCol && neighbourCol >=0)) {
					
					if(grid[neighbourRow][neighbourCol] == 1) {
						grid[neighbourRow][neighbourCol] = 2; //i.e. rotting the fresh orange
						freshOranges--;
						
						queue.addLast(new RPair(neighbourRow,neighbourCol));//now adding the rotten orange to the queue
					}
					
					
				}
				
				
			}
			
			
		}
		
		return freshOranges==0?timeTaken:-1;
		
		
	}
	
	public static void main(String[] args) {
		int[][] grid = {{2,1,1},
						{1,1,0},
						{0,1,1}};
		
		int result = orangesRotting(grid);
		System.out.println("Total time taken for rottening the oranges are: " + result);
		
		
	}

}
