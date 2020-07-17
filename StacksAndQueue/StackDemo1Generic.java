package stackANDqueue;

import java.util.ArrayList;

class StackArrayG<T>{
	
//	private T[] array;  //creating generic array using T - which means Template
	private ArrayList<T> array;
	private int top;
	private final int DEFAULT_CAPACITY = 10;
	
	StackArrayG(){
//		array = new T[DEFAULT_CAPACITY];
		top = -1;
		array = new ArrayList<>(DEFAULT_CAPACITY);

	}
	
	StackArrayG(int capacity){
		if(capacity<1) {
			throw new RuntimeException("Invalid Capacity");
		}
		
		top = -1;
//		array = new T[capacity];
		array = new ArrayList<>(capacity);
	}
	
	private int getSize() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return getSize() == 0;
	}
	
	public void push(T data) {

//		if(getSize() == array.length) { // to check if we have reached to end of array
		
//		if(getSize() == array.size()) {
//			throw new RuntimeException("Stack is full");
//		}
		//not necessary in case of arrayList as it doubles its size when we reaches to last
		
		
		top++;
//		array[top] = data;
		
		array.add(top, data);
		
//		array.add(data);  //this will add data to last index which won't be top
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		
//		int value = array[top];
//		int value =(int) array.get(top);  //we have to type cast to (int) as the ArrayList by default is of Object
		T value = array.get(top);  //we have to type cast to (int) as the ArrayList by default is of Object

//		array[top] = 0;
//		array.set(top, 0);  //error: he method set(int, T) in the type ArrayList<T> 
							//is not applicable for the arguments (int, int)
		
		array.set(top, null);
		top--;
		return value;
	}
	
	public T topElement() {
		if(getSize() == 0) {
			throw new RuntimeException("Stack is empty cannot pick top element");
		}
		
//		return array[top];
//		return array.get(top);  // error: Type mismatch: cannot convert from Object to int
//		return (int) array.get(top); //there we have to type cast to (int)
		
		return array.get(top); //T with generic

	}
	
	public void display() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		
		for(int i = top; i>=0; i--) {
//			System.out.println("Element at position: " + i + " is: " + array[i])	;
			System.out.println("Element at position: " + i + " is: " + array.get(i));

		}
	}
}


public class StackDemo1Generic {

	public static void main(String[] args) {

		StackArrayG<Object> s = new StackArrayG<>();
		s.push(10);
		s.push(7);
		
		s.display();
		
		System.out.println("Top element is: " + s.topElement());
		
		System.out.println(s.pop());
		
		System.out.println("Top element is: " + s.topElement());  
		
		System.out.println(s.pop());
		
		
	}

}

