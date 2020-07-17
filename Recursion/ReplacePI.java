package recursion;

public class ReplacePI {
	
	static String str = "pippppiiiipi";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(replace_pi(0));
		
	}
	
	static String replace_pi(int i) {
		
		if(i == str.length()) {return "";}
		
		if(i+1<str.length() && str.charAt(i) == 'p' && str.charAt(i+1) == 'i') {
			return "3.14" + replace_pi(i+2);
		}
		else {
			return str.charAt(i) + replace_pi(i+1);
		}
		
		
	}

}
