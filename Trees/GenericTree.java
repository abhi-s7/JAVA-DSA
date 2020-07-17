package Trees;

import java.util.ArrayList;
import java.util.Scanner;

//this generic class node will hold n number of children of parents
class TreeNodeG{
	int data;
	ArrayList<TreeNodeG> children;  //choosing arrayList as we would have to write whole operations
									//LinkedList in the case which would be time consuming
	TreeNodeG(int data){
		this.data = data;
		this.children  = new ArrayList<>();
	}
	
}

class TreeOperations{
	
	Scanner scan = new Scanner(System.in);
	
	TreeNodeG addChild() {
		
		TreeNodeG parent;
		
		//entering the data of the node
		System.out.println("Enter the Node data");
		int data = scan.nextInt();
		parent = new TreeNodeG(data);
		
		//taking the children
		System.out.println("Enter the children of: " + data + "th Node: ");
		int noOfChildren = scan.nextInt();
		
		for(int i=1; i<=noOfChildren; i++) {
			TreeNodeG child = addChild(); //recursive call to add child in subtree
			parent.children.add(child);
			
		}
		
		return parent;
		
	}
	
	void printTree(TreeNodeG root) {
		String str = root.data + "=>";
		
		for(TreeNodeG child : root.children) {
			str += child.data + ",";
		}
		
		System.out.println(str);
		
		for(TreeNodeG child : root.children) {
			printTree(child); //this will make child as new root and above printing will be done
		}
		
	}
	
	int getHeight(TreeNodeG root) {
		if(root == null) {
			return 0;
		}
		
		if(root.children.size() == 0) {
			return 1;
		}
		
		//root will have children if we reach till here
		int max = 0;
		for(int i = 0; i<root.children.size(); i++) {
			int currentHeight = getHeight(root.children.get(i));
			max = Math.max(currentHeight, max);
		}
		
		return max+1;
	}
}

public class GenericTree {
	
	public static void main(String[] args) {
		TreeOperations tree = new TreeOperations();
		TreeNodeG root = tree.addChild();
		
		tree.printTree(root);
		System.out.println("Height of the tree: " + (tree.getHeight(root) - 1)); //if we consider height as edges not levels
		
	}
	
	

}
