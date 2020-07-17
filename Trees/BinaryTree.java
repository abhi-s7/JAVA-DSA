package treesBatch2;

import java.util.LinkedList;
import java.util.Scanner;

class BNode{
	int data;
	BNode left;
	BNode right;
	
	BNode(int data){
		this.data = data;
	}
}

class BinaryTreeOperations{
	
	Scanner scan = new Scanner(System.in);
	
	BNode root; //this way we are preserving the root here
	String str = "parent";
	
	BNode add() {
//		root = null;
		BNode root = null;
		System.out.println("Enter data at " + str);
		int data = scan.nextInt();
		
		if(data == -1) {
			return null;
		}
		
		root = new BNode(data);
//		System.out.println("Enter left data of " + data + " or -1 to exit");
//		int left = scan.nextInt();
//		root.left = new BNode(left);
		
		str = "left of: " + data;
		root.left = add();
		str = "right of: " + data;
		root.right = add();
		str = "parent";
		
		return root;
		
	}
	
	int countNodes(BNode root) {
		if(root == null) {
			return 0;
		}
		
		int count = 1; //for each node
		count += countNodes(root.left);
		count += countNodes(root.right);
		
		return count;

	}
	
	boolean checkIdentical (BNode tree, BNode tree2) {
		
		if(tree == null && tree2 != null)
			return false;
		else if(tree != null && tree2 == null )
			return false; 
		
		if(tree == null && tree2 == null) {
			return true;
		}
		
		checkIdentical(tree.left, tree2.left.left);
		checkIdentical(tree.right, tree2.left.right);
		
		
	}
	
	int height(BNode root) {
		if (root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 0;
		}
		
		int max = 0;
		
		int leftH = height(root.left);
		int rightH = height(root.right);
		
		max = Math.max(leftH, rightH);
//		max = Math.min(max, 
//				Math.min(leftH, rightH));
		//no need of this as we have only two things to compare
		//earlier in generic we didn't know how many childs we had
		
	 
		return max+1;
	}
	
	/*
	 * Traversal ways
	 * 
	 * D = root
	 * L = left
	 * R = right
	 * 
	 * 1. Pre - order (DLR)
	 * 2. Post - order (LRD)
	 * 3. In - order (LDR)
	 */
	
	/*
		 				 
		 			   	  100
		 			  	 *   *
		 			   *       *
 		 		   	 20		    90
		 		    *  *       *  *
		 		   *    *     *    *
		 		  60	70   80     77
		 		  
		 	*****************Pre-order****************
		 	
					100 20 60 70 90 80 77 
			
			*****************In-order*****************
			
					60 20 70 100 80 90 77
			
			*****************Post-order***************
			
					60 70 20 80 77 90 100
					
			******************************************

	 */
	
	void preorder(BNode root) {
		if(root == null) {
			return;
		}
		
		//we will first print data
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
 
	}
	
	void inorder(BNode root) {
		if(root == null) {
			return;
		}
		
		inorder(root.left);
				System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	void postorder(BNode root) {
		if(root == null) {
			return;
		}
		
		postorder(root.left);
		postorder(root.right);
		
		System.out.print(root.data + " ");
	}
	
	
	void print(BNode root) {
		if(root == null) {
			return;
		}
		String str = root.data + " => ";
		
		if(root.left != null) {
			str +="L: " + root.left.data + " ";
//			print(root.left); 
			/*
			 * if i specify here then o/p will start from the very left node
			  	1 => 
				2 => 
				10 => 1 2 
			 */
		}
		
		if(root.right != null) {
			str +="R: " +  root.right.data + " ";
//			print(root.right);

		}
		
		System.out.println(str);
		print(root.left);
		print(root.right);	
	}
	
	void levelOrderPrint(BNode root) {
		if(root == null) {
			return;
		}
		//JAVA has linked list which acts like a queue class
		LinkedList<BNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			//take the first element from queue , print it and add its child back to queue
			//BNode parent = queue.poll();
			BNode parent = queue.removeFirst();

			System.out.println(parent.data);
			if(parent.left != null)
				queue.add(parent.left);
			
			if(parent.right != null)
				queue.add(parent.right);
			
		}
		
	}
	
	
}

public class BinaryTree {

	public static void main(String[] args) {
		
		BinaryTreeOperations bt = new BinaryTreeOperations();
		bt.root = bt.add();
		bt.print(bt.root);
		System.out.println(bt.height(bt.root));
		
		System.out.println("*****************Pre-order****************");
		
		bt.preorder(bt.root);
		System.out.println("*****************In-order****************");

		bt.inorder(bt.root);
		
		System.out.println("*****************Post-order****************");
		bt.postorder(bt.root);
		
		/*
		 
		 
		 	100 => L: 20 R: 90 
			20 => L: 60 R: 70 
			60 => 
			70 => 
			90 => L: 80 R: 77 
			80 => 
			77 => 
		 
		 	*****************Pre-order****************
			100 20 60 70 90 80 77 
			*****************In-order*****************
			60 20 70 100 80 90 77
			*****************Post-order***************
			60 70 20 80 77 90 100
		 
		 
		 */

		System.out.println("*****************LEVEL ORDER PRINTING************");
		bt.levelOrderPrint(bt.root);
		
		
	}

}
