package recursion;

public class PalindromeString {

	public static void main(String[] args) {
		
		String str = "PLALZP";
		
		System.out.println(palindrome(str,0,str.length()-1));

	
	}

	static boolean palindrome(String str, int start, int end) {
		
		
		if(start>end) {return true;}
		
		if(start == end) {return true;}
		
		if(str.charAt(start) != str.charAt(end)) {return false;}
		
		return palindrome(str, ++start, --end);
	}
}
