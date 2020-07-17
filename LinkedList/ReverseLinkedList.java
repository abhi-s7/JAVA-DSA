package LinkedList;

import java.util.Stack;

class ClassReverseLL<T> extends LinkedListOperations<T>{
	
	/*
	 * Approach Naive
	 * 1. Traverse a LL and keep adding into the Stack
	 * 2. When temp has reched to the null
	 * 3. POP from stack and add it into another LL
	 * 
	 * TC: O(2N) SC: O(N)
	 * 
	 */
	
	void reverseNaive() {
		Stack<T> stack = new Stack<T>();
		Node<T> temp = start;
		while(temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		
		temp  = start;
		while(!stack.isEmpty()) {//till the stack is not empty
			
			temp.data = stack.pop();
			temp = temp.next;
			
		}
		
		
	}
	
	/*
	 * Approach 2 - Three pointer approach
	 * 1. Aim is to reverse the pointer of every node
	 * 2. start points to the null & tail points to the previous element
	 * 3. Maintain 3 pointers namely [prev, current, next
	 * 4. At beginning: prev - is at null, current & next are at start
	 * 5. Step1:- move forward next
	 * 6. Step2:- Make link of current with prev this way start point to null
	 * 7. Step3- This way we have lost link to the next node but we have [next] in the game
	 * 8. Step4:- Shift prev to current position, 
	 * 			  	    current to next position,
	 * 					next to further next position
	 * 9. loop till next reaches null
	 * 
	 * TC: O(N) SC: O(1)
	 */
	void reverse3Pointer() {
		
		Node<T> prev = null;
		Node<T> current = start;
		Node<T> next = start;
	
		/********************This way next has already moved further and we are moving
		 * next again in the loop so it doesn't take the last element and it is out of the
		 * loop
		 */
//		
//		Node<T> next = start.next;
//
//		while(next!=null) {
//			
//			current.next = prev;
//			prev = current;
//			current = next;
//			next = next.next;
//			
//		}
		
//		while(current!=null) {
//			
//			current.next = prev; //links with previous node
//			prev = current; //shift prev to current
//			current = next; //shifts current to next
//			next = next.next; //shift next by one position
//			
//		}
//		start = prev;
		
		//AS per the above logic the current remains at current position only as we 
		//haven't moved the next before current. So how will current take the position of next
		while(next!=null) {
			next = next.next;
			current.next = prev;
			prev = current;
			current = next;
			
		}

		
		start = prev;
	}
	
	
	/*
	 * Approach 3  - Recursively
	 * Same as first approach but we are using Stack of recursion
	 * 
	 */
	
	void reverseRecursively(Node<T> temp, Node<T> temp2) {
		if(temp.next == null) {
			return;
		}
		int data = (int) temp.data;
		temp = temp.next;

		reverseRecursively(temp,temp2);

		temp2.data = temp.data;
		temp2 = temp2.next;//this doen't have effect as when the stack falls temp2 agian
						//jumps to first position
		
	}
}

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassReverseLL<Integer> sll = new ClassReverseLL<Integer>();
		
		sll.insertAtEnd(new Node<Integer>(1));
		sll.insertAtEnd(new Node<Integer>(2));
		sll.insertAtEnd(new Node<Integer>(3));
		sll.insertAtEnd(new Node<Integer>(4));
		sll.insertAtEnd(new Node<Integer>(5));
		sll.insertAtEnd(new Node<Integer>(6));
		
//		sll.reverseNaive();
		sll.reverse3Pointer();
//		Node<Integer> temp1 = sll.start;
//		Node<Integer> temp2 = sll.start;
//
//		sll.reverseRecursively(temp1, temp2);
		sll.print();

	}

}
