package stackANDqueue.Revise;

public class RReverseStack {
	
	static void reverse(StackArray stack, StackArray dup, int index) {
		
		if(stack.isEmpty()) {
			return;
		}
		
		//dup.push(stack.pop());
		int data = stack.pop();
//		index++; //this makes it pre increment
		reverse(stack,dup,index+1);//but we had to do post increment
		dup.push(data);
		
		if(index == 0) {
			while(!dup.isEmpty()) {
				stack.push(dup.pop());
			}
			
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		StackArray sr = new StackArray();
		
		sr.push(10);
		sr.push(20);
		sr.push(30);
		sr.push(40);
		sr.push(50);
		
		reverse(sr, new StackArray(),0);
		sr.display();
		
	}

}
