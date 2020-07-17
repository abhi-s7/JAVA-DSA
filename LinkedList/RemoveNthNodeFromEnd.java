package LinkedList;

class RemoveNthNode<T> extends LinkedListOperations<T>{
	
	int removeNthNode(int n) {
		
		//L-N
		Node<T> fast = start;
		Node<T> slow = start;
		
		for(int i=1; i<= n+1 ; i++) {
			fast = fast.next;
		}
		
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		int deletedItem =(int) slow.next.data;
		slow.next = slow.next.next;
		
		return deletedItem;
		
	}
}

public class RemoveNthNodeFromEnd {
	public static void main(String[] args) {
		
		RemoveNthNode<Integer> sll = new RemoveNthNode<Integer>();
		
		sll.insertAtEnd(new Node<Integer>(1));
		sll.insertAtEnd(new Node<Integer>(2));
		sll.insertAtEnd(new Node<Integer>(3));
		sll.insertAtEnd(new Node<Integer>(4));
		sll.insertAtEnd(new Node<Integer>(5));
		sll.insertAtEnd(new Node<Integer>(6));

		System.out.println("Deleted Element: " + sll.removeNthNode(2))
		;
		
	}

}
