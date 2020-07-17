package stackANDqueue;

public class StackDemo1 {

	public static void main(String[] args) {

		StackArray s = new StackArray();
		s.push(10);
		s.push(7);
		
		s.display();
		
		System.out.println("Top element is: " + s.topElement());
		
		System.out.println(s.pop());
		
		System.out.println("Top element is: " + s.topElement());
		
		System.out.println(s.pop());
		
		
	}

}

class StackArray{
	
	private int[] array;
	private int top;
	private final int DEFAULT_CAPACITY = 10;
	
	StackArray(){
		array = new int[DEFAULT_CAPACITY];
		top = -1;
	}
	
	StackArray(int capacity){
		if(capacity<1) {
			throw new RuntimeException("Invalid Capacity");
		}
		
		top = -1;
		array = new int[capacity];
	}
	
	public int getSize() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return getSize() == 0;
	}
	
	public void push(int data) {
		if(getSize() == array.length) {
			throw new RuntimeException("Stack is full");
		}
		
		top++;
		array[top] = data;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		
		int value = array[top];
		
		array[top] = 0;
		top--;
		return value;
	}
	
	public int topElement() {
		if(getSize() == 0) {
			throw new RuntimeException("Stack is empty cannot pick top element");
		}
		
		return array[top];
	}
	
	public void display() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		
		for(int i = top; i>=0; i--) {
			System.out.println("Element at position: " + i + " is: " + array[i])	;
		}
	}
}
