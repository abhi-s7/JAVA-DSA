package recursion;

import java.util.ArrayList;

public class BoardPathProblem {

	public static void main(String[] args) {

		//System.out.println(reachToBoard(0,10));
		boardPathWithoutAL(0,5,"");
		
	}
	
	static void boardPathWithoutAL(int start, int end, String result) {
		
		if(start == end) {
			System.out.print(result + " ");
			return;
		}
		
		if(start>end) {
			return;
		}
		
		for(int dice = 1; dice<=6; dice++) {
			int currentResult = start + dice;
			
			boardPathWithoutAL(currentResult , end , result + dice);
		}
	}
	
	static ArrayList<String> reachToBoard(int currNum, int end) {
		
		if(currNum == end) {
			ArrayList<String> t = new ArrayList<>();
			t.add("");
			return t;
		}
		
		if(currNum>end) {
			ArrayList<String> t = new ArrayList<>();
			return t;
		}
		
		ArrayList<String> result = new ArrayList<>();
		
		for(int dice = 1; dice<=6; dice++) {
		
			ArrayList<String> temp = reachToBoard(currNum + dice, end);
			for(String str : temp) {
				result.add(dice + str);
			}
			
		}
		
		return result;
	
	}

}
