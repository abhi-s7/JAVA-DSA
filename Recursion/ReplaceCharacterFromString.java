package recursion;

public class ReplaceCharacterFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(replaceChar("Hello", 'l', 'p',""));

	}
	
	static String replaceChar(String str, char pre,char post, String output) {
		
		if(str.length() == 0)
			return output;
		
		if(str.charAt(0) == pre) {
			output += post;
		}else {
			output += str.charAt(0);
		}
		
		return replaceChar(str.substring(1),pre,post,output);
		
	}

	
	
}
