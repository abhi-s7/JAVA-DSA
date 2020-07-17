package LinkedList;

class ClassFindMiddleEle <T>extends LinkedListOperations <T>{
	
	/*
	 * Approach 1 - Naive
	 * 1. Traverse the whole linked list and find out the length 
	 * 2. Middle element is length/2
	 * 3. Traverse the LL to the Middle element
	 * 4. Take out the data by node.data
	 * 
	 * TC: O(2N) SC: O(1)
	 */
	int midddleElement1() {
		Node<T> temp = start; 
		
		int length = 0;
		while(temp != null) {
			temp = temp.next;
			length++;
		}
		
		//now we got the length we have to reach to the middle element of the list
		temp = start;
				
		int i=1;
		while(i<=length/2) {
			temp = temp.next;
			i++;
		}
		
		//now return the data of temp at that position
		int data = (int) temp.data;
		temp = null;
		return data;
		
	}
	
	/*
	 * Approach 2 - Fast & Slow Pointer
	 * 1. Fast moves two nodes at a time
	 * 2. Slow moves one node at a time
	 * 3. When fast reaches end i.e. fast becomes null
	 * 4. Then slow will be at middle point
	 * 
	 * TC: O(N) SC: O(1)
	 */
	
	int midddleElementFastnSlow() {
		Node<T> fast = start; 
		Node<T> slow = start; 
		
		if(fast == null || slow == null) {
			throw new RuntimeException("Linked List is Empty");
		}
		
		if(fast.next.next == null) {
			throw new RuntimeException("Only two elements");
		}
		
		//it works for the even number of elements
//		while(fast.next.next != null) { // this means that fast has reached to the last pointer
//			fast = fast.next.next;
//			slow = slow.next;
//		}
		
		//so specify 2 conditions
		while(fast.next != null &&
				fast.next.next != null) { // this means that fast has reached to the last pointer
			
		fast = fast.next.next;
		slow = slow.next;
	}
		
		//now return the data of temp at that position
		int data = (int) slow.data;
		slow = null;
		return data;
		
	}

}// ClassFindMiddleEle ends


public class FindMiddleElement {
	
	
	public static void main(String[] args) {
		ClassFindMiddleEle<Integer> sll = new ClassFindMiddleEle<Integer>();
		
		sll.insertAtEnd(new Node<Integer>(1));
		sll.insertAtEnd(new Node<Integer>(2));
		sll.insertAtEnd(new Node<Integer>(3));
		sll.insertAtEnd(new Node<Integer>(4));
		sll.insertAtEnd(new Node<Integer>(5));
		
		System.out.println("Naive Approach: " + sll.midddleElement1());
		System.out.println("Fast n Slow Pointer: " + sll.midddleElementFastnSlow());

		
		
	}
	
}
