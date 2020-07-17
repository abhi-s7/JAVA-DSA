package Trees;

import java.util.Scanner;

class TreeNode{
	int data;
	TreeNode leftNode;
	TreeNode rightNode;
	
	TreeNode(int data){
		this.data = data;
	}
}

// as the name suggest it will have not more than two nodes as binary is (0,1)
public class BinaryTree {
	
	static Scanner scan = new Scanner(System.in);
	static String node = "Root";
	
	static TreeNode addChild(){
		
		System.out.println("Enter the data at " + node);
		int data = scan.nextInt();
		if(data == -1) { //this can be treated as base case
			return null;
		}
		
		//creating TreeNode object which will hold the data
		TreeNode tree = new TreeNode(data);
		node = "left of: " + data;
		tree.leftNode = addChild(); //this will make recursive call for left node followed by right
		
		node = "right of: " + data;
		tree.rightNode = addChild();
		
		return tree; //returns the object of TreeNode which will hold the values
		
	}
	
	static void printTree(TreeNode root) {
		if(root == null) {
			return;
		}
		
		String output = root.data + " => ";
		
//		if(root.leftNode == null) { //this will return if any child is null and will not give proper result
//			return;
//		}
//		output+="Left: " + root.leftNode.data;
		
		if(root.leftNode != null) {
			output+="Left: " + root.leftNode.data;
		}
		
		if(root.rightNode != null) {
			output+="Right: " + root.rightNode.data;
		}
		
		System.out.println(output);
		
		printTree(root.leftNode);
		printTree(root.rightNode);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode node = addChild();
		printTree(node);
		
		

	}

}
