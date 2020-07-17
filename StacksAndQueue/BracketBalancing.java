package stackANDqueue;

import java.util.Stack;

public class BracketBalancing {
	
	public static void main(String[] args) {
		System.out.println(bracket("{[()]}")?"Balanced":"Unbalanced");
		
	}
	
	static boolean bracket(String expression) {
		Stack<String> stack = new Stack<>();
		for(int i = 0; i<expression.length(); i++) {
			char cc = expression.charAt(i);
			
			if( cc == '(' || cc== '[' || cc=='{') {
				stack.push(String.valueOf(cc));
				continue;
			}
			else if(stack.empty()) {
				return false;
			}
			
			switch(expression.charAt(i)) {  //this will give the brackets
			case ')':
				String x = stack.peek();
				stack.pop();
				if(x.equals("[") || x.equals("{")) {
					return false;
				}
				break;
				
			case ']':
				x = stack.peek();
				stack.pop();
				if(x.equals("(") || x.equals("{")) {
					return false;
				}
				break;
				
			case '}':
				x = stack.peek();
				stack.pop();
				if(x.equals("[") || x.equals("(")) {
					return false;
				}
				break;
				
				
			}//end of switch
			
		}
		
		//check of empty stack
		return (stack.empty());
	}
	

}
