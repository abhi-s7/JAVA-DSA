package LinkedList;

//class Node3<T>{
//	T data;
//	Node3<T> next;
//	
//	Node3(T data){
//		this.data = data;
//	}
//}

class LinkedListInsertionLoop <T> extends LinkedListOperations<T>{

	
	
	void detectLoop() {
		Node<T> slow; //moves one node at a time
		Node<T> fast; //move two nodes at once
		
		slow = fast = start;
				
//		while(slow != null) {
		while(fast != null && fast.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				System.out.println("Loop detected");
				return;
			}
						
		}
		
		System.out.println("No Loop found");
		
	}
	
	int getSize() {
		Node<T> temp = start;
		int size = 0;
		while(temp != null) {
			temp = temp.next;
			size++;
		}
		return size;
	}
	
	Node<T> getNodeAtIndex(int index){
		
		Node<T> temp = start;
		
		for(int i=1; i<=index; i++) {
			temp = temp.next;
		}
		
		return temp;
	}
	
	void reverseDataInLinklist() {
		
		//take two index left = start and right is size of linkedList
		int left = 0;
		int right = getSize() - 1;
		
		Node<T> leftNode;
		Node<T> rightNode;
		T tempData;
		
		while(left<right) {
			
			leftNode = getNodeAtIndex(left);
			rightNode = getNodeAtIndex(right);
			
			//swapping
			tempData = rightNode.data;
			rightNode.data = leftNode.data;
			leftNode.data = tempData;
			
			left++;
			right--;
		}		
		
	}
	
	Node<T> getLastNode() {
		Node<T> temp = start;
		int size = 0;
		while(temp != null) {
			temp = temp.next;
		}
		return temp;
	}
	
	void reverseNodeInLinkedList() {
		int left = 0;
		int right = getSize() - 1;
		
		Node<T> leftNode;
		Node<T> rightNode;
		Node<T> rightPrev;
		Node<T> temp;		
		while(left < right) {
			leftNode = getNodeAtIndex(left);
			rightNode = getNodeAtIndex(right);
			rightPrev = getNodeAtIndex(right-1);
			
			temp = rightNode;
			temp.next = leftNode.next;
//			rightNode = leftNode;
			rightPrev.next = leftNode;
			
			leftNode = temp;
			
			
		}	
		
	}
	
	void reversePointers() {
		Node<T> previous;
		Node<T> current;
		Node<T> ahead;
		
		previous = start;
		current = previous.next;
		
		while(current != null) {
			ahead = current.next;  //ahead is initialized in while because ahead will be after current and we are
								//running loop till current != null. So current.next will give null pointer exception
			current.next = previous;
			
			previous = current;
			current = ahead;
			
		}
		
		Node<T> temp = start; //so that start doesn't destroys
		start = tail; //tail will be at end
		tail = temp; //assigning tail to starting position
		tail.next = null;
				
	}
	
	void print() {
		Node<T> temp = start;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}

public class FindLoopInLinkedList <T>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListInsertionLoop<Integer> linkedList = new LinkedListInsertionLoop<>();
		
		linkedList.insertAtBeg(new Node<>(10));
		linkedList.insertAtEnd(new Node<>(20));
		linkedList.insertAtEnd(new Node<>(30));
		linkedList.insertAtEnd(new Node<>(40));
		linkedList.insertAtEnd(new Node<>(50));
//		
//		linkedList.detectLoop();
		linkedList.print();
//		System.out.println("****************After swapping**************");
//		linkedList.reverseDataInLinklist();
//		linkedList.print();
//
		System.out.println("****************After Reversing**************");
		linkedList.reversePointers(); //sir's approach
		linkedList.print();
	}
	
	

}
