package BackTracking;

public class CoinChangeProblem {
	
	static void ccPermutation(int D[], int amount,String result) {
		
		if(amount == 0) {
			System.out.println(result);
			return;
		}
		
		for(int i = 0; i<D.length;i++) {
			
			if(amount>=D[i]) {
				ccPermutation(D,amount-D[i],result + D[i]);
			}
			
		}
	}
	
	static void ccCombinations(int D[], int amount, String result,int lastIndex) {
		
		if(amount == 0) {
			System.out.println(result);
			return;
		}
		
		for(int i = lastIndex; i<D.length;i++) {
			
			if(amount>=D[i]) {
				ccCombinations(D,amount-D[i],result + D[i], i);
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int D[] = {2,3,5,6};
		//ccPermutation(D,10,"");
		ccCombinations(D,10,"",0);

	}

}
