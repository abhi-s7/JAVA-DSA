package DynamicProgramming;

public class MinimumCostPath {
	
	static int mcp(int[][] cost, int m, int n) {
		
		if (m<0 || n<0){
			return Integer.MAX_VALUE; //so that it will be maximum and when compared for smaller number it won't be chosen
			//as this case is -ve case when m or n goes beyond the line
		}
		
		if(m == 0 && n == 0) {
			//we have reached to the target point
			return cost[0][0];
		}
		
		int aboveRow = mcp(cost, m-1, n);
		int aboveCol = mcp(cost, m, n-1);
		int aboveDiag = mcp(cost, m-1, n-1);
		
		int minVal = Math.min(
				Math.min(aboveRow, aboveCol), aboveDiag);
		//we are sending the minimum of all the three to the next cell
		
		return cost[m][n] + minVal;
		
	}
	
	static int mcpDP(int cost[][]) {
		int result[][] = new int[cost.length][cost.length];
		
		//to avoid overlapping of the sub problem
		
		//assigning cost(0,0) to the result as from there we will start adding the min cost
		result[0][0] = cost[0][0];
		//col Cell
		for(int i = 1; i<cost.length; i++) {
			result[0][i] = cost[0][i] + result[0][i-1];
		}
		
		//row Cell
		for(int i = 1; i<cost.length; i++) {
			result[i][0] = cost[i][0] + result[i-1][0];
		}
		
		//for the diagonal part
		for(int i = 1; i<cost.length; i++) {
			for(int j = 1; j<cost.length; j++) {
				//we have to add the previous row, previous column & previous diagonal element into (i,j)
				result[i][j] = Math.min(result[i-1][j-1],
						Math.min(result[i-1][j], result[i][j-1])) + cost[i][j];
			}
		}
		
		return result[result.length -1][result.length -1];
	}
	
	public static void main(String[] args) {
		int cost[][] = {
				{2,0,6},
				{3,1,7},
				{4,5,9}
		};
		
//		int result = mcp(cost,2,2);
		int result = mcpDP(cost);
		System.out.println(result);
		
	}
}
