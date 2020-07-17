package stackANDqueue;

import java.util.*;

public class NextGreaterElement_using_stack {

	//Time Complexity = NLOGN
	
	public static void main(String[] args) {

		int arr[] = {4,5,2,25};
		Stack<Integer> stack = new Stack<>();		
		
		for(int currElement : arr) {
			
			while(!stack.isEmpty() && currElement > stack.peek()) {
//				while(!stack.isEmpty() && currElement < stack.peek()) {   //for next smaller element
				int top = stack.pop();
								System.out.println(top + "->" + currElement);
			}
			
			stack.push(currElement);
			
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + "->" + -1);
		}
		
	}

}
