package LinkedList;

class SplitLinkedList<T> extends LinkedListInsertionLoop<T>{
	// odd position numbers in one list
	// even position numbers in another
	
	void splitLL() {
		Intersection<T> opr1 = new Intersection<>();
		Intersection<T> opr2 = new Intersection<>();
		
		Node<T> temp = start;
		int position = 1;
		while(temp != null) {
			
			if(position % 2 == 0) { //even position
				opr2.insertAtEnd(temp);
			}else {
				opr1.insertAtEnd(temp);
			}
			//in this approach i'm adding whole linkedList again n again at end
			//at last only one of their tail gets null
			position++;
			temp = temp.next;
			
		}
		
		opr1.print();
		System.out.println("**************************");
		opr2.print();
	}
	
	void splitLL2() {
		Node<T> temp = start;
//		Node<T> tempS = start;
		
		Node<T> p = temp;
		Node<T> q = temp.next;
		
		while(p.next.next != null && q.next.next !=null) {
			p = p.next.next;
			q= q.next.next;
		}
		
		p.next = null;
		q.next = null;
		
		Intersection<T> opr1 = new Intersection<>();
		Intersection<T> opr2 = new Intersection<>();
		
		opr1.insertAtEnd(p);
		opr2.insertAtEnd(q);
		
		
		opr1.print();
		System.out.println("**************************");
		opr2.print();
		
		
	}
	
	Node[] splitLL3() {
		
		Node<T> L1 = null;
		Node<T> L2 = null;
		
		Node<T> temp = start; //start is original ll start
		
		
		while(temp != null) {
			
			Node<T> newNode = temp;
			temp = temp.next;
			
			newNode.next = L1;
			L1 = newNode;
			
			if(temp!=null) {
				
				newNode = temp;
				temp = temp.next;
				
				newNode.next = L2;
				L2 = newNode;
			}
			
		}
		
		return new Node[] {L1,L2};
		
		
	}
	
	Node<T> splitUsingDummy() {
		Node<T> current = start;
	
		Node<T> aDummy = new Node();
		Node<T> aTail = aDummy;
		
		aDummy.next = null;
		
		while(current != null) {
			
			Node<T> newNode = current;
			current = current.next;
			
			newNode.next = aTail.next;  //this will seperate the newNode and make it independent
										//aTail.next is always null thus it sets the 
										//linkage of newNode to null
			aTail.next = newNode;

			aTail = aTail.next;	
			

			Node bDummy = new Node();
			Node bTail = bDummy; // points to the last node in 'b'
			bDummy.next = null;
			
			if (current != null)
			{
				// add at 'b' tail

				newNode = current;
				current = current.next;

				newNode.next = bTail.next;
				bTail.next = newNode;

				bTail = bTail.next;	 // advance the 'b' tail
			}
			
		}
		
		return  aDummy.next;
	}
	
	void splitLRP() { //using LRP = LocalReferencePointer
		
		Node<T> current = start;
		Node<T> L1 = new Node();
		Node<T> L2 = new Node();
		
		while(current != null) {
			Node<T> local = start;
			
			
		}
		
		
		
	}
	
	
	
	
	

}

public class SplitLinkedListAlternative {
	
	public static void printList(String msg, Node head)
	{
		System.out.print(msg);

		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}

		System.out.println("null");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitLinkedList<Integer> sll = new SplitLinkedList<Integer>();
		sll.insertAtEnd(new Node<Integer>(1));
		sll.insertAtEnd(new Node<Integer>(2));
		sll.insertAtEnd(new Node<Integer>(3));
		sll.insertAtEnd(new Node<Integer>(4));
		sll.insertAtEnd(new Node<Integer>(5));
		
//		Node[] nodeArray = sll.splitLL3();
//		
//		printList("First List  : ", nodeArray[0]);
//		printList("Second List : ", nodeArray[1]);
		
		Node<Integer> node = sll.splitUsingDummy();
		printList("Split Node: " , node);
				
//		sll.splitLL3();

	}

}
