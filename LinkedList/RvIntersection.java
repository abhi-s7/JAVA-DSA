package LinkedList;

class ClassIntersection<T> extends LinkedListOperations<T>{
	
	int getSize(Node<T> startNode) {
		Node<T> temp = startNode;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next; 
		}
		
		return count;
	}
	
	Node<T> getNodeAtIndex(int index, Node<T> startNode) {
		Node<T> temp = startNode;
		int i=1;
		while(i<index) {
			//this will run one less time the index and we will reach to that index 
			//as we are sitting at first node
			temp = temp.next;
			i++;
		}
		
		return temp;
	}
	
	/*
	 * Appraoch Naive
	 * 1. We have to run two loops
	 * 2. Take first element of the L1 then
	 * 3. Run second loop till L2 ends and compare each node
	 * 4. repeat step 2-3 until we reach L1 end or we found intersection
	 * 
	 * TC O(M*N)
	 */
	
	/*
	 * Approach 2
	 * 1. Use HashMap
	 * 2. while traversing from List one start adding its node addresses to hashmap
	 * 3. While traversing the second list search in hashmap whether it present or not
	 * 4. End if found intersection
	 * 
	 * TC O(M+N) SC O(M/N)
	 */
	
	/*
	 * Aproach Best
	 * 1. Compute the size of both the lists
	 * 2. Diff is big - small
	 * 3. Traverse the bigList to the diff so that both the list comes to same position
	 * 4. Start Traversing both the list 
	 * 5. If there is intersection then we'll find out as both the list are traversing from same startpoint
	 * 6. NOTE:: This trick is only valid if intersection is at { mid of bigList or greater } As then only diff can be in whole number
	 * 
	 * TC O(N) SC (1)
	 */
	
	boolean intersection(Node<T> L1, Node<T> L2) {
		
		Node<T> startBig;
		Node<T> startSmall;
		
		int sizeL1 = getSize(L1);
		int sizeL2 = getSize(L2);
		int diff = 0;
		
		if(L1 == null || L2 == null) {
			System.out.println("Either of the LL is null");
			return false;
		}
		
		if(L1.next == null && L2.next == null) {   //only one node
			System.out.println("Intersection not possible as there is only one node");
			return false;
		}
		
		if(sizeL1>= sizeL2) {
			diff = sizeL1 - sizeL2;
			startBig = L1;
			startSmall = L2;
		}
		else {
			diff = sizeL2 - sizeL1;
			startBig = L2;
			startSmall = L1;
		}
		
		
		
		for(int i = 1; i<= diff; i++) {
			startBig = startBig.next;
		}
		
		while(startBig !=  null) {
			if(startBig == startSmall) {
				return true;//i.e. we have found the intersection as at that point both node will have same address
			}
			
			startBig = startBig.next;
			startSmall = startSmall.next;
			
		}
		
		return false;
	}
	
	
}

public class RvIntersection {

	public static void main(String[] args) {
		ClassIntersection<Integer> opr1 = new ClassIntersection<Integer>();
		opr1.insertAtEnd(new Node<Integer>(10));
		opr1.insertAtEnd(new Node<Integer>(20));
		opr1.insertAtEnd(new Node<Integer>(30));
		opr1.insertAtEnd(new Node<Integer>(40));
		opr1.insertAtEnd(new Node<Integer>(50));
		
		ClassIntersection<Integer> opr2 = new ClassIntersection<Integer>();
		opr2.insertAtEnd(new Node<Integer>(700));
		opr2.insertAtEnd(new Node<Integer>(900));
	
		opr2.tail.next = opr1.getNodeAtIndex(4, opr1.start);
		//i.e.  we are adding 40 to the next of 900
		
		boolean result = opr1.intersection(opr1.start, opr2.start);
		System.out.println(result?"Intersection Found": "Intersection Not Found");
		
		
		
	}
	
}
