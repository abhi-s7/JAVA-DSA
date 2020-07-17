package LinkedList;

import java.util.Stack;

class ClassPalindrome<T> extends LinkedListOperations<T>{
	
	
	/*
	 * Approach 1 - Naive
	 * 1. Read every node from start and add it's data to the stack
	 * 2. When temp reaches null again loop through LL and start checking it's data with stack data
	 * 3. Pointer is that while stack falls it gives data first which is stored last in it.
	 * 4. This way we are able to check the LL that it's data is same from start as well as last
	 * 
	 * TC - O(2N) SC- O(N)
	 */
	
	boolean palindromeNaive() {
		Node<T> temp = start;
		Stack<T> stack = new Stack<T>();
		
		while(temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		
		temp = start;
		while(temp != null) {
			if(!temp.data.equals( stack.pop())) {
				return false;
			}
			temp = temp.next;
		}
		
		return true;
		
	}
	
	/*
	 * Approach 2
	 * 1. Find out mid element using {fast and slow pointer}
	 * 2. Split the LL after the mid and reverse it
	 * 3. Start searching for the same element in both the LL
	 * 4. If the matches then it is palindrome else not
	 * 
	 * TC - O(2N) SC- O(N)
	 */
	
	boolean palindrome2() {
		Node<T> fast = start;
		Node<T> slow = start;
		
		while(fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		Node<T> newStart = slow.next;
		slow.next = null;
		
		/*****Reversing the second List********/
		Node<T> prev = null;
		Node<T> current = newStart;
		Node<T> next = null;
		
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		newStart = prev;
		
		Node<T> temp = start;
		Node<T> temp2 = newStart;
		
		while(temp!=null && temp2!=null) {
			if(!temp.data.equals(temp2.data)) {
				return false;
			}
			temp = temp.next;
			temp2 = temp2.next;
		}
		
		return true;
	}
}

public class PalindromeInLL {
	
	public static void main(String[] args) {
		ClassPalindrome<String> sll = new ClassPalindrome<String>();
		sll.insertAtEnd(new Node<String>("M"));
		sll.insertAtEnd(new Node<String>("A"));
		sll.insertAtEnd(new Node<String>("D"));
		sll.insertAtEnd(new Node<String>("A"));
		sll.insertAtEnd(new Node<String>("M"));
		
		String result = sll.palindrome2()?"It is Palindrome":"Not Palindrome";
		System.out.println(result);
		
	}

}
