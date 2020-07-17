package recursion;

public class RecurisonBasics3Skipping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		skipping(5);

	}
	
	static void skipping(int value) {
		if (value == 0) {
			return;
		}
		
		if(value % 2 == 0) {
			skipping(value - 1);
			System.out.println(value);
		}
		
		if(value % 2 != 0) {
			System.out.println(value);
			skipping(value - 1);
		}
	}

}
