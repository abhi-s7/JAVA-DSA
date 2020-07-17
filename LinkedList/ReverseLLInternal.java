package LinkedList;

public class ReverseLLInternal {
	
	static Node<Integer> reverse(Node<Integer> start) {
//		System.out.println("reverse start " + start);
		//maintaining 3 pointers
		Node<Integer> current, prev, next;
		current = start;
		prev = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}
		
		//**************************************************************
							//start = prev;
		/* but here we are setting the prev to the local start not the start of the LL
		 * To do so we have to do opr.start = prev then it will set
		 * If we try to print from (opr.start) it will print only 10 even if we have reversed it
		 * because the start is sitting at 10 and through this code we have set the link of 10 with null
		 * but we could not reinitialize the global start to 50 through this code. So beware of this
		 * 
		 */
		//***************************************************************
		//System.out.println("New Start " +start);

		
		return prev;
	}
	
	static void print2(Node<Integer> start) {
		Node<Integer> temp = start;
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedListOperations<Integer> opr = new LinkedListOperations<>();
		opr.insertAtEnd(new Node<Integer>(10));
		opr.insertAtEnd(new Node<Integer>(20));
		opr.insertAtEnd(new Node<Integer>(30));
		opr.insertAtEnd(new Node<Integer>(40));
		opr.insertAtEnd(new Node<Integer>(50));
		
//		System.out.println("50 element " + opr.start.next.next.next.next);
//		System.out.println("10 element " + opr.start);
		Node<Integer> st = reverse(opr.start);
		//**********************************************************
		
		//opr.start = st;
		print2(st);
		
		// if we don't do this then the start of the opr will not be initialized with the last node
		// as through opr.start  we reaches to the LL start
		//************************************************************
		
//		System.out.println("After reverse 10 element " + opr.start);
//		System.out.println("After reverse 50 element " + opr.start.next);
//
//
	
//		opr.print();
//		print2(opr.start);
	}
}
