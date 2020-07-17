package BackTracking;

public class HackTheBank {
	
	public static void main(String[] args) {
		
		if(hack(20000)) {
			System.out.println("Hacked");
		}else
			System.out.println("Number cannot be hacked");
		
	}
	
	static boolean hack(int num) {
		
		if(num == 1) {
			return true;
		}
		
		if(num%20 == 0)
			return true;
		
		if(num%10 == 0)
			return true;
		
		return false;
	}

}
