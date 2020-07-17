package stackANDqueue;

public class ReverseStackRecursively {

	public static void main(String[] args) {
		
		StackArray s = new StackArray();
		s.push(10);
		s.push(20);
		s.push(30);
		
		StackArray dup = new StackArray();
		
		reverse(s,dup,0);
		s.display();
		
	}
	
	static void reverse(StackArray org, StackArray dup, int index) {
		
		if(org.isEmpty()) {
			return;
		}
		
		
		int data = org.pop();
		
		System.out.println("Pop value is: " + data);
		
		reverse(org,dup,index+1);
		
		dup.push(data);
		
		if(index == 0) {
			while(!dup.isEmpty()) {
				
				org.push(dup.pop());
			}
			
		}
		
		
	}

}
