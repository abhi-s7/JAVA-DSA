package recursion;

public class ReplacePIusingsubstring {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "pippppiiiipii";

		System.out.println(replaceAllpi(str));
		
	}
	
	static String replaceAllpi(String str) {
		
		if(str.length() <= 1) {return str;}
		
		
		if(str.charAt(0) == 'p' && str.charAt(1) == 'i') {
			return "3.14" + replaceAllpi(str.substring(2));
		}
		else {
			return str.charAt(0) + replaceAllpi(str.substring(1));
		}
		
	}

}
