package recursion;

public class RemoveCharacFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(remove("hello",'l'));

	}
	
	static String remove(String str, char remove) {
		
		if(str.length() == 0) {return "";}
		
		String output = "";
		
		if(str.charAt(0) != remove) {
			output += str.charAt(0);
		}
		
		return output + remove(str.substring(1),'l');
	}

}
