package recursion;

public class SumOfGPSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(gp(3));

	}
	
	static double gp (int num) {
		
		if(num == 0) {return 1;}
		
		return gp(num-1) + 1/Math.pow(2, num);
		
	}

}
