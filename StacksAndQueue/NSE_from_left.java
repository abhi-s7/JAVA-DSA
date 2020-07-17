package stackANDqueue;

import java.util.Stack;

public class NSE_from_left {

	public static void main(String[] args) {
		int arr[] = {4,5,1,2,3,25};
		Stack<Integer> stack = new Stack<>();		
		
		for(int currElement : arr) {
			
			
			if(!stack.isEmpty() && currElement > stack.peek() ) {
				System.out.println( currElement + "->" + stack.peek() );
				stack.pop();
			}
			
			stack.push(currElement);
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + "->" + -1);
		}
	}

}
