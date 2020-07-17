package stackANDqueue.Revise;

import java.util.Stack;

public class ExpressionSolver {
	
	static int bodmas(char e) {
		switch(e) {
		case '^': 
			return 3;
		case '*': 
			return 2;
		case '/': 
			return 2;
		case '+': 
			return 1;
		case '-': 
			return 1;
		default:
			return -1;
			
		}
	}
	
	static boolean isOperator(char c) {
		return (c=='^' || c == '*'|| c == '/'|| c == '+'|| c == '-');
	}
	
	static int solve(int first, int second, char opr) {
		switch(opr) {
		case '^': 
			return first^second;
		case '*': 
			return first*second;
		case '/': 
			return first/second;
		case '+': 
			return first+second;
		case '-': 
			return Math.abs(first-second);
		default:
			return -1;
		}
	}
	
	//2+3*5-6
	static int solver(String expression) {
		
		Stack<Integer> number = new Stack<>();
		Stack<Character> operator = new Stack<>();
		
		for(int i=0; i<expression.length(); i++) {
			char firstChar = expression.charAt(i);
			
			if(Character.isDigit(firstChar)) {
				//number.push((int) firstChar);//(int) char converte
				number.push(Integer.parseInt(String.valueOf(firstChar)));
			}	
			else if(isOperator(firstChar)) {
				
				if(!operator.isEmpty() && bodmas(firstChar) < bodmas(operator.peek())){
					
					while(!operator.isEmpty() && bodmas(firstChar) <= bodmas(operator.peek())) {
						char opr = operator.pop();
						int first = number.pop();
						int second = number.pop();
						
						int result = solve(first,second,opr);
						number.push(result);
					}
					
					operator.push(firstChar);
					
					
				}else {
					operator.push(firstChar);
				}
				
				
			}
		}
		
		while(!operator.isEmpty()) {
			char opr = operator.pop();
			int first = number.pop();
			int second = number.pop();
			
			int result = solve(first,second,opr);
			number.push(result);
		}
		
		return number.pop();
		
	}
	
	public static void main(String[] args) {
		String expression = "2+3*5-6";
		String expression2 = "5-6*3+4";
		String expression3 = "2*4-6";
		System.out.println(solver(expression3));
	}

}
