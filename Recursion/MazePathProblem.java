package recursion;

import java.util.ArrayList;

public class MazePathProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(maze(0,0,2,2));
		mazeWithoutAL(0,0,2,2,"");

	}
	
	static void mazeWithoutAL(int h, int v, int X, int Y, String result) {
		
		if(h>X || v>Y) {
			return;
		}
		
		if(h==X && v == Y) {
			System.out.print(result + " ");
			return;
		}
		
		mazeWithoutAL(h+1, v, X, Y, result + "H");
		mazeWithoutAL(h,v+1,X,Y, result + "V");
		mazeWithoutAL(h+1,v+1,X,Y,result + "D"); //diagonal case therefore increment h & v by one
		
	}
	
	static ArrayList<String> maze(int h, int v, int X, int Y){
		
		
		if(h>2 || v>2) {
			ArrayList<String> t = new ArrayList<>();
			return t;
		}
		
		if(h==2 && v==2) {
			ArrayList<String> t = new ArrayList<>();
			t.add("");
			return t;
		}
		
		ArrayList<String> horResult = new ArrayList<>();
		ArrayList<String> tempHor = maze(h+1,v,X,Y);
		
		for(String str : tempHor) {
			horResult.add(str + "H");
//			return horResult;
		}
		ArrayList<String> verResult = new ArrayList<>();
		ArrayList<String> tempVer = maze(h,v+1,X,Y);
		
		for(String str : tempVer) {
			verResult.add(str + "V");
//			return verResult;
		}
		
		ArrayList<String> finalList = new ArrayList<>();
		finalList.addAll(horResult);
		finalList.addAll(verResult);
		
		return finalList;
		
		
	}

}
