package stackANDqueue;

import java.util.*;

public class RedundantBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String expression = "(a+b)";
		//((a-b) * (c+d)
		
		System.out.println(bracketSolver(expression)?"Yes":"NO");

	}
	
	static boolean bracketSolver(String str) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(char c : str.toCharArray()) {
			
			if(c=='(' || Character.isLetterOrDigit(c) || isOperator(c)) {
				stack.push(c);
			}
			else if(c == ')')
			{
				while(!stack.isEmpty() && c != '(') {
					
					char ch = stack.pop();
					
					if(isOperator(ch) || ch == '(') {
						return false;
					}
					
				}
				
				return true;
			}
			
			
		}
		
		return true;
		
		
	}
	
	
	static boolean isOperator(char ch) {
		if(ch == '^' || ch == '*' || ch == '/' ||
				ch == '+' || ch == '-') {
			return true;
		}
		
		return false;
	}
	

}
