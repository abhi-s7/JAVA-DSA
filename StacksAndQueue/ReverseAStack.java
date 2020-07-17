package stackANDqueue;

public class ReverseAStack {
	
	public static void main(String[] args) {
		StackArray stack = new StackArray();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		stack.display();
		
		reverse(stack);
		
		System.out.println(stack.getSize());
		
	//	stack.display();  this will give error as the reference we changed get destroyed 
		//with the destruction of reverse method.
		//so display reverse stack within reverse method with this approach
		
	}
	
	static void reverse(StackArray stack) {
		
		StackArray stackTemp = new StackArray();
		
		System.out.println(stack.getSize());
		
		for(int i = stack.getSize()-1 ; i>=0; i--) {  //getSize() method gives = top + 1 
													// so it moves out of array :: getSize()-1
			stackTemp.push(stack.pop());
		}
		
		if(stack.isEmpty()) {
			stack = stackTemp;
		}
	}

}
