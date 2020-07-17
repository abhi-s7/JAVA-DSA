package LinkedList;

class Intersection<T> extends LinkedListInsertionLoop<T> {
	
//	@Override //The method getSize(Node<T>) of type Intersection<T> must override or implement a supertype method
	int getSize(Node<T> startNode) {
		
		Node<T> temp = startNode;
		int size = 0;
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		
		return size;
		
	}
	
	
	
	boolean findIntersection(Node<T> L1, Node<T> L2) {
		
		/*	1. find the length of two LL L1 & L2
		 * 	2. let L1>L2
		 * 	3. Assumption: Intersection is done at mid point or after midpoint of L1 
		 * 	4. Algorithm: 
		 * 		a) Calculate diff of L1 and L2 
		 * 		b) Move L1 pointer to the diff location so that both the LL are at same position
		 * 		c) Then start shifting both the linkList by one position till L1 != null
		 * 		d) if(L1 == L2.next) => intersection
		*/	
		
		Node<T> startBigL;
		Node<T> startShortL;
		
		int diff = 0;
		
		if(L1 == null || L2 == null) {
			System.out.println("Either of the LL is null");
			return false;
		}
		
		if(L1.next == null && L2.next == null) {   //only one node
			System.out.println("Intersection not possible as there is only one node");
			return false;
		}
		
		int m = getSize(L1);
		int n = getSize(L2);
		
		System.out.println("L1 size: " + m + "L2 size: " + n);
		
		if(m>n) {  //when L1 > L2
			diff = m-n;
			startBigL = L1;
			startShortL = L2;
			
		}
		else {   //m<n
			
			diff = n - m;
			startBigL = L2;
			startShortL = L1;
			
		}
		
		for(int i = 1; i<=diff; i++) {
			startBigL = startBigL.next;
		}
		
		while(startBigL != null) {	
			
			if(startBigL == startShortL) {
				System.out.println("HEHE");
				return true;
			}
			
			startBigL = startBigL.next;
			startShortL = startShortL.next;
			
			
		}
		
		return false;
	
				
	}
	
}

public class FindIntersectionInTwoLL {
	
	public static void main(String[] args) {
		Intersection<Integer> opr = new Intersection<>();
		
		opr.insertAtBeg(new Node<Integer>(10));
		opr.insertAtEnd(new Node<Integer>(20));
		opr.insertAtEnd(new Node<Integer>(30));
		Node<Integer> interNode = new Node<Integer>(40);
		opr.insertAtEnd(interNode);
		opr.insertAtEnd(new Node<Integer>(50));
		
		Intersection<Integer> opr2 = new Intersection<>();
		opr2.insertAtBeg(new Node<Integer>(700));
		opr2.insertAtEnd(new Node<Integer>(900));
//		opr2.insertAtEnd(interNode); //this way we have intersected the node
//		opr2.insertAtEnd(new Node<Integer>(1100));
		
		//**********or to connect list do this******************
		opr2.tail.next = opr.getNodeAtIndex(2); //this will intersect at 30, if index=3 then intersect at 40 of opr

		boolean result = opr.findIntersection(opr.start, opr2.start);
		
		System.out.println(result?"Intersection found":"No intersection");

		
	}
	
	

}
