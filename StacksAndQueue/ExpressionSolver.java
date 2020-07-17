package stackANDqueue;

/*
 * 1. take characters out of string using charAt(index)
 * 2. check if it is operator or operand
 * 3. maintain two stacks for operand and operator both
 * 4. push if operand occur
 * 5. push each successive precedence operator
 * 6. if conquered less precedence operator the in while(pop operators till reached
 * to less precedence
 * 7. with every pop of operator pop two operand and perform operation
 * then push the result.
 * 
 */

public class ExpressionSolver {
	
	// 2+3*5-6
	
	public static void main(String[] args) {
		
		System.out.println(expressionSolver("2+3*5-6"));
		
	}

	static int expressionSolver(String expression) {
	
	StackArrayG<Object> stackR = new StackArrayG<>();
	StackArrayG<Object> stackD = new StackArrayG<>();
	
	for(int i = 0; i<expression.length(); i++) {
		char currChar = expression.charAt(i);
		
		if(Character.isDigit(currChar)) {
			stackD.push(String.valueOf(currChar));
		}else {
			if(stackR.isEmpty()) {
				stackR.push(currChar);
			}else {
				if(precedence((char)stackR.topElement()) < precedence(currChar)) {
					stackR.push(currChar);
				}else {
					while(!stackR.isEmpty() && precedence((char)stackR.topElement()) >= precedence(currChar)) {
						char operator = (char) stackR.pop();
						int operand1 = Integer.parseInt((String) stackD.pop()) ;
						int operand2 = Integer.parseInt((String) stackD.pop()) ;
						
						int result = resultSolver(operator, operand1, operand2);
						stackD.push(String.valueOf(result));
						
					}
					
					stackR.push(currChar);
				}
				
			}
		}
	}
	
	while(!stackR.isEmpty()) {
		
		char operator = (char) stackR.pop();
		int operand1 = Integer.parseInt((String) stackD.pop()) ;
		int operand2 = Integer.parseInt((String) stackD.pop()) ;
		
		int result = resultSolver(operator, operand1, operand2);
		stackD.push(String.valueOf(result));
		
	}
	
	return Integer.parseInt((String) stackD.topElement());
	
	
}

static int precedence(char operator) {
	
	switch(operator) {
	
	case '*': return 2;
	case '/': return 2;
	case '+': return 1;
	case '-': return 1;
	default: return -1;
	
	}
	
}

static int resultSolver(char operator, int operand1, int operand2) {
	switch(operator) {
	case '*': 
		return operand1 * operand2;
		
	case '/': 
		return operand1 / operand2;
		
	case '+': 
		return operand1 + operand2;
		
	case '-': 
		return Math.abs(operand1 - operand2);
		
	default: return -1;	
	}
}

}














