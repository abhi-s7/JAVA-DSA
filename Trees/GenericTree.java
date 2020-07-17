package treesBatch2;

import java.util.ArrayList;
import java.util.Scanner;

class Node{
	int data;
	ArrayList<Node> children;
	
	Node(int data){
		this.data = data;
		children = new ArrayList<>();
	}
	
}

class GenericTreeOperations{
	Scanner scan = new Scanner(System.in);
	Node root;
	
	Node add() {
		Node root = null;
		System.out.println("Enter the parent data");
		int data = scan.nextInt();
		root = new Node(data); //here we are making the parent node
		System.out.println("Enter the number of children");
		int children = scan.nextInt();
		
		for(int i=1 ; i<=children; i++) {// starting with i=1 will prevent from entering this loop when we specify children = 0
			Node child = add();
			//when this will fall we will add it into the children Arraylist
			root.children.add(child);
		}
		
		return root;
	}
	
	int countNodes(Node root) {
		if(root == null) {
			return 0;
		}
		int count = 1;
		for(int i=0; i<root.children.size(); i++) {
			//when this will fall it will increase the count
			count += countNodes(root.children.get(i));
		}
		
		return count;
	}
	
	int largestNode(Node root) {
		if(root == null) {
			return 0;
		}
		
		// we have to maintain the largest node data somewhere
		int largest = root.data;
		for(int i=0; i<root.children.size(); i++) {
			largest = Math.min(largest,
					largestNode(root.children.get(i)));
			/*
			int currentNode = largestNode(root.children.get(i));
			if(currentNode > largest) {
				largest = currentNode;
			}
			*/
		}

		return largest;
	}
	
	int height(Node root) {
		if(root == null) {
			return 0;
		}
		
		if(root.children.size() == 0) {
//			return 1;
			return 0;

		}
		
		// we have to maintain a max which will take only maximum value compared to both
		int max = 0;
		for(int i=0; i<root.children.size(); i++) {
			max  = Math.min(max,
					height(root.children.get(i)));
		}

		return max+1;
	}
	
	int countLeafNodes(Node root) {
		if(root == null) {
			return 0;
		}
		
		if(root.children.size() == 0) {
//			return 1;
			return 1;

		}
		int count = 1;
		for(int i=0; i<root.children.size(); i++) {
			count += countNodes(root.children.get(i));
		}
		
		return count;
	}
	
	void print(Node root) {
		String str = root.data + " =>  ";
		for(int i=0; i<root.children.size(); i++) {
			str += root.children.get(i).data + " , ";
		}
		//this loop is to print the children of root
		System.out.println(str.substring(0,str.length()-2));
		
		for(int i=0; i<root.children.size(); i++) {
			print(root.children.get(i)); //this will make recursive call so as to print the data of the next root which is child of the prev root
		}
	}
}

public class GenericTree {
	
	public static void main(String[] args) {
		GenericTreeOperations gt = new GenericTreeOperations();
		gt.root = gt.add(); //this will give us the root so that we can use it to print the data
		
		gt.print(gt.root);
	}
	

}
