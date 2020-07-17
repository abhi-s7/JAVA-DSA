package recursion;

import java.util.ArrayList;

public class PermutationOfString {

	public static void main(String[] args) {

//		System.out.println(perm("abc"));
		permWithoutAL("abc","");
		
	}
	
	static void permWithoutAL(String str, String result) {
		
		if(str.length() == 0) {
			//base case
			System.out.println(result);
			return;
		}
		
		for(int i=0; i<str.length();i++) {
			char singleChar = str.charAt(i);
			String remainingstr = str.substring(0,i) + str.substring(i+1);
			
			permWithoutAL(remainingstr, result + singleChar);
		}
		
	}
	
	static ArrayList<String> perm(String str){
		
		if(str.length() == 0) {
			ArrayList<String> empty = new ArrayList<>();
			empty.add("");
			return empty;
		}
		
		
		char currChar = str.charAt(0);
		
		String remainingstr = str.substring(1);
		
		ArrayList<String> result = new ArrayList<>();
		
		ArrayList<String> temp = perm(remainingstr);
		
		for(String s: temp) {
			
			for(int i = 0; i<=s.length(); i++) {
				StringBuilder sb = new StringBuilder(s);
				sb.insert(i, currChar);
				result.add(sb.toString());
			}
			
		}
		
		return result;
		
		
	}

}
