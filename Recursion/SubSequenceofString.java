package recursion;

import java.util.ArrayList;

public class SubSequenceofString {

	public static void main(String[] args) {
		
//		System.out.println(sub("abc"));
		subsequenceVoidMethod("abc","");


	}
	
	static void subsequenceVoidMethod(String str, String result) {
		
		if(str.length() == 0) {
			System.out.println(result);
			return;
		}
		
		char singleChar = str.charAt(0);
		String remainingString = str.substring(1);
		
		subsequenceVoidMethod(remainingString, result);
		subsequenceVoidMethod(remainingString, result + singleChar);
	}
	
	static ArrayList<String> sub(String str){
		
		if(str.length() == 0) {
			ArrayList<String> empty = new ArrayList<>();
			empty.add("");
			return empty;
		}
		
		
		char currChar =  str.charAt(0);
		
		String subStr = str.substring(1);
		
		ArrayList<String> result = new ArrayList<>();
		
		ArrayList<String> temp = sub(subStr);
		
		for(String s:temp) {
			
			result.add(s);
			result.add(currChar + s);
			
		}

		return result;
		
		
	}

}
