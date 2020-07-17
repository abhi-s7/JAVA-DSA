package BackTracking;

import java.util.ArrayList;

public class KeyPadCombinations {
	
	//creating an array which will hold the key pad characters	
	//it is index wise as keypad number 2 will have "abc"
	static String[] keypad = new String[] {"!","-","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

	
	static ArrayList<String> keypadPerm(String number){
		
		//base case 
		if(number.length() == 0) {
			ArrayList<String> blank = new ArrayList<>();
			blank.add("");
			return blank;
		}
		
		char currentChar = number.charAt(0);
		String remainingString = number.substring(1);
		
		int currentIndex = currentChar - '0';
		String keys = keypad[currentIndex];
		
		ArrayList<String> finalResult = new ArrayList<>();
		
		for(char key : keys.toCharArray()) {
			
			ArrayList<String> temp = keypadPerm(remainingString);
			for(String str : temp) {
				
				finalResult.add(key + str);
			}
				
		}
		
		return finalResult;
	}
					//number = "23"  2 = "abc" & 3 = "def"
	static void keypadPermVoid(String number, String result) {
		
		if(number.length() == 0) {
			System.out.print(result + " ");
			return;
		}
		
		char firstChar = number.charAt(0);
		String remainingString = number.substring(1);
		int index = firstChar - '0';
		String keys = keypad[index];
		
		for(char key : keys.toCharArray()) {
			
			keypadPermVoid(remainingString,result + key);
		}
	}
	
	public static void main(String[] args) {
		//System.out.println(keypadPerm("23"));
		keypadPermVoid("23","");
	}

}
