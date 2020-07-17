package BackTracking;

public class WordBreaker {
	
	static boolean inDictonary(String prefix) {
		String[] dictonary = {"i","like", "likes", "iphone","sam","phone", "sung", "samsung" , "mo","mobile"};
		
		for(String temp : dictonary) {
			if(temp.equals(prefix))
				return true;
		}
		return false;
	}
	
	static void wordBreaker(String word, String result) {
		
		for(int i = 1; i<=word.length(); i++) {
			
			String prefix = word.substring(0,i);

			if(inDictonary(prefix)) {
				
				if(i == word.length()) {
					System.out.println(result + prefix + " ");
					return;
				}
				
				wordBreaker(word.substring(i,word.length()), result + prefix + " ");
				
			}
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		wordBreaker("ilikesamsungmobile","");
	}

}
