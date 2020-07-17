package LinkedList;

public class SplitCircularLLInHalf {
	
	/*
	 * Approach-Fast and Slow Poiter
	 * 1. use fast and slow pointer initialize it with start
	 * 2. move fast 2 times while slow 1 time
	 * 3. Check fast.next != start -- this is for even list & fast.next.next != start for even list
	 * 4. When it is out of the loop
	 * 		a) Link fast with the next of slow i.e. fast.next = slow.next
	 * 		b) Link slow with the start i.e. slow.next = start
	 * 5. Return them in array and print seperately
	 * 
	 * TC: O(N) SC: O(1)
	 */
	
	static Node<Integer>[] splitCircular(Node<Integer> start){
		Node<Integer> fast, slow;
		fast = slow = start;
		
		while(fast.next!=start && fast.next.next != start) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		Node<Integer> newStart;
		newStart = slow.next;
		fast.next = newStart;
		slow.next = start;
		
		return new Node[]{newStart, start};
	}
	
	static void print(Node<Integer> start) {
		Node<Integer> temp = start;
		//we are using do while because we want to run the loop for first iteration as with using while
		//it moves out of the loop when in (temp!=start) condition as at first temp is start only
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}while(temp!=start);
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedListOperations<Integer> opr1 = new LinkedListOperations<Integer>();
		
		opr1.insertAtEnd(new Node<Integer>(10));
		opr1.insertAtEnd(new Node<Integer>(20));
		opr1.insertAtEnd(new Node<Integer>(30));
		opr1.insertAtEnd(new Node<Integer>(40));
		opr1.insertAtEnd(new Node<Integer>(50));
		opr1.tail.next = opr1.start; //through this we have created the link of last node 
		//to the first node and created it circular
		
		Node[] arr = splitCircular(opr1.start);
		print(arr[0]);
		print(arr[1]);
		
	}

}
