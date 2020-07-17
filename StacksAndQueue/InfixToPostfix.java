package stackANDqueue;

import java.util.*;

public class InfixToPostfix {
	
	public static void main(String[] args) {
		
		System.out.println(infixToPostfix("A+(B*C-(D/E^F)*G)*H"));
		
	}
	
	static String infixToPostfix (String expression) {
		Stack<Character> stack = new Stack<>();
		
		stack.push('(');
		StringBuffer output = new StringBuffer();
		
		for(int i = 0; i<expression.length(); i++) {
			char symbol = expression.charAt(i);
			
			if(Character.isLetterOrDigit(symbol)) {
				output.append(symbol);
			}
			else 
			{
				
				if(symbol == '(')
					stack.push(symbol);
				
				else if(symbol == '^' || symbol == '*' ||
						symbol == '/' || symbol == '+' ||
						symbol == '-') {
					
					if(stack.isEmpty() || stack.peek() == '(')
						stack.push(symbol);
					else if(Precedence(stack.peek())<Precedence(symbol))
						stack.push(symbol);
					else {
						while(stack.peek() != '(' && Precedence(stack.peek())>=Precedence(symbol)) {
							output.append(stack.pop());
						}
//						if(stack.peek() == '(')
//							stack.pop(); // i was not pushing the less precedence symbol
										// rather popping '('
						stack.push(symbol);

					}
					
					
				}
				
				else if(symbol == ')') {
					while(!stack.isEmpty() && stack.peek() != '(') {
						output.append(stack.pop());
					}
					
					if(!stack.isEmpty() && stack.peek()!='(')
						return "Invalid Expression";
					else
						stack.pop();
				}
				
				
//				else if(stack.isEmpty() || (!stack.isEmpty() && stack.peek() == '(') || symbol == '(') {
//					stack.push(symbol);
//				}
//				else if(Precedence(stack.peek())>=Precedence(symbol)) {
//					while(stack.peek() == '^' || 
//							stack.peek() == '*' || stack.peek() == '/' ||
//							stack.peek() == '+' || stack.peek() == '-') {
//						output.append(stack.pop());
//					}
//					if(stack.peek() == '(')
//						stack.pop();
//				}
				
			}
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek() == '(')
				stack.pop();
			else
				output.append(stack.pop());
		}
		
		return String.valueOf(output);
		
	}
	
	
	static int Precedence(char operator) {
		
		switch(operator) {
		
		case '^': return 3;
		case '*': return 2;
		case '/': return 2;
		case '+': return 1;
		case '-': return 1;
		default : return -1;
		
		}
		
	}


}

