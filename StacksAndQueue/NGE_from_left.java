package stackANDqueue;

import java.util.Stack;

public class NGE_from_left {

	public static void main(String[] args) {
		int arr[] = {4,5,2,3,75,25};
		Stack<Integer> stack = new Stack<>();		
		
		for(int currElement : arr) {
			
			
			if(!stack.isEmpty() && currElement < stack.peek() ) {
				System.out.println( currElement + "->" + stack.peek() );
				continue;
			}
			
			stack.push(currElement);
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + "->" + -1);
		}
	}

}
