package stackANDqueue;

import java.util.*;

public class ReversePolishNotation {
	
	public static void main(String[] args) {
		Object[] arr = {'2','1','+','3','*'};
		
		System.out.println(reversePolish(arr));
	}

	static int reversePolish(Object[] arr) {
		
		Stack<Object> operandStack = new Stack<>();
		
		for(int i = 0; i<arr.length; i++) {
			char currentElement = (char) arr[i];
			if(Character.isDigit(currentElement)) {
				operandStack.push(currentElement);
			}else {
				int operand1 = Integer.parseInt(String.valueOf(operandStack.pop())) ;
				int operand2 = Integer.parseInt(String.valueOf(operandStack.pop())) ;
				
				int result = resultSolver(currentElement, operand1, operand2);
				operandStack.push(String.valueOf(result));
			}
		}
		
		return Integer.parseInt((String) operandStack.peek());
		
		
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
