package LinkedList;

public class SplitLLinAlternateFashion {
	
	static Node<Integer> split(Node<Integer> start) {
		
		Node<Integer> start2 = start;
		Node<Integer> temp, temp2;
		
		if(start == null) {
			throw new RuntimeException("LL is empty");
		}
		
		if(start.next == null) {
			throw new RuntimeException("Only one element in the LL and cannot be split");
		}
		start2 = start2.next;
		
		temp = start;
		temp2 = start2;
		
//		while(temp.next !=null && temp.next.next != null) {
//			temp = temp.next.next;
//			temp2 = temp.next.next;
//		}
//		
//		temp2.next = null;
		
		while(temp.next != null && temp2.next != null) {
			System.out.print(temp.data + " ");
			System.out.println();
			System.out.print(temp2.data + " ");
			//making link with node while skipping one in between
			temp.next = temp.next.next;
			temp2.next = temp2.next.next;
			//now we have to move the pointer to that node
			temp = temp.next;
			temp2 = temp2.next;
		}
		//this is to take care of odd condition
		if(temp.next != null) {
			temp.next = null;
		}
		
		return start2;
		
	}
	
static Node<Integer> split2(Node<Integer> start) {
		
		Node<Integer> start2 = start;
		Node<Integer> temp, temp2;
		
		if(start == null) {
			throw new RuntimeException("LL is empty");
		}
		
		if(start.next == null) {
			throw new RuntimeException("Only one element in the LL and cannot be split");
		}
		start2 = start2.next;
		
		temp = start;
		temp2 = start2;
		
		while(temp != null && temp.next != null && temp.next.next != null) {
			System.out.print("temp: " + temp.data + " ");
			System.out.print("temp2: " + temp2.data);
			System.out.println();
			temp.next = temp.next.next;
			temp2.next = temp2.next.next;
			//now we have to move the pointer to that node
			temp = temp.next;
//			if(temp2.next != null) {
//				temp2 = temp2.next;
//			}
			temp2 = temp2.next;
		}
		
		if(temp.next != null) {
			temp.next = null;
		}
//		temp2.next = null;
		return start2;
		
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
		LinkedListOperations<Integer> opr = new LinkedListOperations<Integer> ();
		
		for(int i = 10; i<=40; i=i+10) {
			opr.insertAtEnd(new Node<Integer>(i));
		}
		
		Node<Integer> start2 = split2(opr.start);
		print(opr.start);
		print(start2);
		
	}

}
