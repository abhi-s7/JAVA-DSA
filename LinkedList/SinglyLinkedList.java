package LinkedList;

class Node<T>{
	T data;
	Node<T> next;
	
	Node(T data){
		this.data = data;
		this.next = null;
	}
	
	Node(){}
//	@Override
//	public String toString() {
//		return "Data: " + data + "Ref: " + next;
//	}
//	

	
}

class LinkedListOperations<T>{
	Node<T> start;
	Node<T> tail;
	
	void kthNodeFromEnd(int k) {
		Node<T> p,q;
		p = q = start;
		
		for(int i = 1; i<=k; i++) {
			q = q.next;
		}
		
		while(q != null) {
			q = q.next;
			p = p.next;
		}
		
		System.out.println("Kth node from end: " + p.data);
	}
	
	void insertAtPosition(Node<T> node, int position) {
		
		//when no nodes exists
		if(start == null) {
			node = start;
			return;
		}
		
		//position = 0
		if(position == 0) {
			node.next = start;
			start = node;
		}
		
		if(position > 0) {
			
			Node<T> temp = start;
			int i = 1;
			while(i<position) {
				temp = temp.next;
				i++;
			}
			node.next = temp.next;
			temp.next  = node;
			
		}
		
	}
	
	void insertAtBeg(Node<T> node) {
		if(start == null) {
			tail = start = node;
			return;
		}
		
		node.next = start;
		start = node;
	}
	
	void insertAtEnd(Node<T> node) {
		//if no elements present
		if(start == null) {
			tail = start = node;
			return;
		}else {
			tail.next = node;
			tail = node;
		} //this way we don't have to traverse through whole loop to insert element at end
		
		/* OLD APPROACH
		 * //one element present if(start.next == null) { start.next = node; return; }
		 * 
		 * //more than one element present Node<T> temp = start;
		 * 
		 * while(temp.next != null) { //this means until the last element gets null temp
		 * = temp.next; }
		 * 
		 * temp.next = node;
		 */
	}
	
	void deleteNode(T data) {
		Node<T> temp = start;
		
		if(start == null) {
			throw new RuntimeException("LinkList is empty :(");
		}
		
		//data found on first node
		if(start.data == data) {
			if(start.next == null) {
				start = null;
				return;
			}
			temp = start;
			start = start.next; //we should use temp node to assign it with start,
								//then shift the start
								//and delete the temp node by temp = null
								//this way memory is optimized
			
			temp = null;
			return;
		}
		
		//data found on another node 

		Node<T> tempPrev = start;
		
		while(temp.next != null) {
			if(temp.data == data) {
				Node<T> temp2 = temp;
				tempPrev.next = temp.next;
				temp2 = null;
			}
			tempPrev = temp;
			temp = temp.next;
		}
	}
	
	void updateNode(T data, T newData) {
		Node<T> temp = start;
		if(start == null) {
			throw new RuntimeException("LinkList is empty :(");
		}
		
		if(start.data == data) {
			start.data = newData;
			return;
		}
		
		while(temp !=null) {
			if(temp.data == data) {
				temp.data = newData;
				return;
			}
			temp = temp.next;
		}		
		
	}
	
	void print() {
		Node<T> temp = start;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}

public class SinglyLinkedList {
	
	public static void main(String[] args) {
		LinkedListOperations<String> llOps = new LinkedListOperations<>();
		
		llOps.insertAtEnd(new Node<String> ("ram"));
		
		llOps.insertAtBeg(new Node<String>("shyam"));
		
		llOps.insertAtEnd(new Node<String>("mohan"));
		
		llOps.insertAtEnd(new Node<String>("sam"));

		llOps.insertAtEnd(new Node<String>("tim"));

		llOps.insertAtEnd(new Node<String>("cook"));

		llOps.insertAtEnd(new Node<String>("alex"));

		
//		llOps.insertAtEnd(new Node2<String>("fourth"));
//		llOps.insertAtEnd(new Node2<String>("fifth"));
//		llOps.insertAtEnd(new Node2<String>("sixth"));
//		
		llOps.print();
		
		System.out.println("******************After deletion*******************");
		llOps.deleteNode("ram");
		llOps.print();
		
		System.out.println("******************After updation*******************");
		llOps.updateNode("mohan", "mohan vilas");
		llOps.print();
		
		System.out.println("******************Kth node*******************");
		llOps.kthNodeFromEnd(2);

	}
	
	
	
}
