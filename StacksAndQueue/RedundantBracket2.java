package stackANDqueue;

import java.util.*;

public class RedundantBracket2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String expression1 = "((a+b))";
		String expression2 = "(a+(b)/c)";
		String expression3 = "(a+b*(c+e(-)d))";
		String expression4 = "(a+b*(c-d))";
		String expression5 = "((a+b)*(c-d))";
//		//((a-b) * (c+d)
//		
		System.out.println(bracketSolver(expression1)?"Yes":"NO");
		System.out.println(bracketSolver(expression2)?"Yes":"NO");
		System.out.println(bracketSolver(expression3)?"Yes":"NO");
		System.out.println(bracketSolver(expression4)?"Yes":"NO");
		System.out.println(bracketSolver(expression5)?"Yes":"NO");


	}
	
	static boolean bracketSolver(String str) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(char singleChar : str.toCharArray()) {
			
			boolean flag = true;
		//	boolean flagOperand = true;
			
			
			if(singleChar == ')') {
				char topElement = stack.pop();
				while(topElement != '(') 
				{
//					
//					if(Character.isLetterOrDigit(topElement))
//						flagOperand = false;
					
					if(isOperator(topElement)) {
						flag = false;
					}
					
					topElement = stack.pop();
				}  //while loop ends
//				if(flag == true || (flagOperand == true && flag == false)) {
				
				if(flag == true) {
					return true;
				}
				
			} //if ends
			
			else {
				stack.push(singleChar);
			}
			
			
		}  //for-each ends
		
		return false;
		
	}
	
	
	static boolean isOperator(char ch) {
		if(ch == '^' || ch == '*' || ch == '/' ||
				ch == '+' || ch == '-') {
			return true;
		}
		
		return false;
	}
	

}
