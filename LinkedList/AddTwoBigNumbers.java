package LinkedList;

public class AddTwoBigNumbers {
	
	static Node<Integer> reverse(Node<Integer> startLocal) {
		Node<Integer> current, prev, next;
		prev = null;
		current = startLocal;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return prev;
	}
	
	static void addition(Node<Integer> start1,Node<Integer> start2) {
		
		
		
		LinkedListOperations<Integer> result = new LinkedListOperations<>();

		
		Node<Integer> temp = start1;
		Node<Integer> temp2 = start2;
				
		int carry = 0;
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		while(temp!= null || temp2 != null) {
			
			// taking the temp 1 data
			if(temp == null)
				data1 = 0;
			else
				data1 = temp.data;
			
			//taking the temp 2 data
			if(temp2 == null)
				data2  =0;
			else
				data2 = temp2.data;
			
			sum = carry + data1 + data2;
			carry = sum/10;
			result.insertAtEnd(new Node<Integer>(sum%10));
			
			if(temp != null)
				temp = temp.next;
			if(temp2 != null)
				temp2 = temp2.next;
			
		}
		//print(result.start);
		print( reverse (result.start));
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
		LinkedListOperations<Integer> opr = new LinkedListOperations<>();
		LinkedListOperations<Integer> opr2 = new LinkedListOperations<>();
		
		String str1 = "12839117";
		String str2 = "345222";
		
		for(char s : str1.toCharArray()) {
			opr.insertAtEnd(new Node<Integer>(
					Integer.parseInt(String.valueOf(s)
							)));
		}
		
		for(char s : str2.toCharArray()) {
			opr2.insertAtEnd(new Node<Integer>(
					Integer.parseInt(String.valueOf(s)
							)));
		}
		
//		print(opr.start);
//		print(opr2.start);
//		
//		System.out.println("**********After Reverse***********");
//		print(reverse(opr.start));
//		print(reverse(opr2.start));
		/*********************These works even it has function inside function*********/
		Node<Integer> s1 = reverse(opr.start);
		Node<Integer> s2 = reverse(opr2.start);
//		print(s1);
//		print(s2);
		addition(s1,s2);
		
		/**********************But this doesn't work ***************************/
		//below code is sending opr.start again after reversing not the reversed pointer
     	//addition( reverse( opr.start), reverse (opr2.start ));

	}
}
