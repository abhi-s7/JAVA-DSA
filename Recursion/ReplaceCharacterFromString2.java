package recursion;

public class ReplaceCharacterFromString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(replaceChar("hello".toCharArray(), 'l', 'p'));

	}
	
	static String replaceChar(char[] str, char find, char replace) {
		
		if(str.length == 0)
			return "";
		
		String output = "";
		
		if(str[0] == find) {
			str[0] = replace;
		}
		
		output = new String(str);
		
		return str[0] + replaceChar(output.substring(1).toCharArray(), find,replace);
		
	}

	
	
}
