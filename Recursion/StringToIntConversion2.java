package recursion;

public class StringToIntConversion2 {
	
	//**************stack falling*****************************

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sti("786"));

	}
	
	static int sti(String str) {
		
		if(str.length() == 1) {
			return str.charAt(0) - '0';
		}
		
		
		int result = sti(str.substring(1));
		
		double firstNum = str.charAt(0) - '0';
		
		double finalNum = firstNum*Math.pow(10, str.length()-1) + result;
		
		return (int) finalNum;
		
		
	}

}
