package recursion;

public class StringToIntConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sti("1234",0));

	}
	
	static int sti(String numStr,int result) {
		
		if(numStr.length() == 0) {return result;}
		
		int firstNum = numStr.charAt(0) - '0';
		
		result += (int) firstNum*(Math.pow(10, numStr.length() -1));
		
		return sti(numStr.substring(1),result) ;
		
		
	}

}
