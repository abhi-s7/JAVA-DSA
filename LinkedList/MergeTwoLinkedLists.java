package LinkedList;

public class MergeTwoLinkedLists {
	
	/*
	 * Approach
	 * 1. Crete a third pointer which will be our new list
	 * 2. Compare first elements of both the list and assign the node having lower value with the third
	 * 3. loop till any of the start not reaches null
	 * 4. Again check for lowest element from the nodes of both the lists
	 * 5. Repeat step 2 then move temp forward and start forward
	 * 6. After the loop if any of the list is remaianing then link up with the third and return it
	 * 
	 * TC: O(M/N) SC: O(1)
	 */

	static Node<Integer> merge(Node<Integer> start, Node<Integer> start2) {
		Node<Integer> third = null;
		
		//we have to check which list's first element is smaller
		if(start.data <= start2.data) {
			third = start;
			start = start.next; //as we have got the first node to third
		}
		else {
			third = start2;
			start2 = start2.next;
		}
		//we have to maintain temp so that our third is not destroyed
		Node<Integer> temp = third;
		while(start!=null && start2 != null) {
			
			if(start.data <= start2.data) {
				temp.next = start; //linking temp with the start
				temp = temp.next;
				start = start.next;
			}
			else {
				temp.next = start2;
				temp = temp.next;
				start2 = start2.next;
			}
		}
		/*
		//now there might be situation where one of the linkedlist is not null
		if(start != null) {
			temp.next = start;
		}
		else if(start2 != null) {
			temp.next = start2;
		}
		********This can be written as below************
		*/
		temp.next = start!=null?start:start2;
		return third;
	}
	
	
	
	
	static void print(Node<Integer> start) {
		Node<Integer> temp = start;
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedListOperations<Integer> opr1 = new LinkedListOperations<Integer>();
		
		opr1.insertAtEnd(new Node<Integer>(10));
		opr1.insertAtEnd(new Node<Integer>(40));
		opr1.insertAtEnd(new Node<Integer>(50));
		opr1.insertAtEnd(new Node<Integer>(70));
		
		LinkedListOperations<Integer> opr2 = new LinkedListOperations<Integer>();
		
		opr2.insertAtEnd(new Node<Integer>(20));
		opr2.insertAtEnd(new Node<Integer>(30));
		opr2.insertAtEnd(new Node<Integer>(60));
		opr2.insertAtEnd(new Node<Integer>(80));
//		opr2.insertAtEnd(new Node<Integer>(90));
		
		Node<Integer> starts = merge(opr1.start, opr2.start);
		
		print(starts);
	
	}
	
	
}
