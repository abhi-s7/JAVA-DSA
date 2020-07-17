package BackTracking;

public class RatInMaze {
	
	static int N;
	
	static void printSolution(int sol[][]) {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				System.out.print(" " + sol[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static boolean isSafe(int maze[][], int x, int y) {
		return (x>=0 && y>=0 && x<N && y<N && maze[x][y] == 1);
	}
	
	static boolean solMaze(int maze[][]) {
		int[][] mazeSolPath = new int[N][N];
		
		if(solMazeUtil(maze, 0, 0, mazeSolPath) == false) {
			System.out.println("Solution doesn't exists");
			return false;
		}
		
		printSolution(mazeSolPath);
		return true;
	}
	
	static boolean solMazeUtil(int maze[][], int x, int y, int sol[][]) {
		
		if(x==N-1 && y==N-1) {
			sol[x][y]=1;
			return true;
		}
		
		if(isSafe(maze,x,y)) {
			sol[x][y]=1;
			
			if(solMazeUtil(maze, x+1, y,sol))
				return true;
			
			if(solMazeUtil(maze, x, y+1,sol))
				return true;
			
			sol[x][y] = 0;
			return false;
			
		}
		
		return false;
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		int maze[][] = { {1,1,0,0},
						 {0,1,1,1},
						 {0,1,0,0},
						 {1,1,1,1} };
		N = maze.length;
		solMaze(maze);
		}
		
	}

