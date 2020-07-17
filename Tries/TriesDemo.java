package Tries;

import java.util.HashMap;
import java.util.Map;

/*
 * Tries is Data Structure used for text-processing
 * eg. Like Google have auto-complete, search in Amazon
 * Tries - Auto-Complete and Dictionary
 * Amazon - Elastic Search but deep down Tries is used. ES is the wrapper, also in AWS
 * 
 * 1. Create a Node which have
 * 			a) character data
 * 			b) HashMap which have key = character and value is Node itself
 * 				i.e. HashMap will contain entries of all the other characters and their further nodes 
 * 			c) isEnd (boolean) which will tell the character is the last character
 * 2. TC of Add, search, remove is same as the TC of world length i.e. O(N)
 * 3. Start from empty node, for that we will create getRoot() method which will return the root node which will form once when 
 * 		tries object is created
 * 4. To add Word create a addWord() which will take the [parent node & word] as arguments
 * 5. Extract firstChar and remainingString using charAt(0) and subString(1) resp.
 * 6. We will extract child node from the parents HashMap which is holding all the nodes of subsequent characters
 * 7. If child node is null then we'll create it and put it in parents Node
 * 8. Call addWord Method recursively where parent node -> childNode and word -> remainingString
 */

class Node{
	char data;
	HashMap<Character,Node> children;
	boolean isEnd;
	
	Node(char data){
		this.data = data;
		this.children = new HashMap<>();// HashMap will be empty but it will be not null as it will create problem when we try to add stuffs
		//this.isEnd = false; //optional as it will be false at beginning
	}
}

class Trie{
	private Node root;
	private int noOfWords;
	
	Trie(){
		root = new Node('\0');//i.e. creating a node of empty String
		noOfWords = 0;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public int getNoOfWords() {
		return noOfWords;
	}
	
	void addWord(Node parent, String words) {
		
		if(words.length() == 0) {
			
			if(parent.isEnd) {
				//i.e. we have reached to the end of the word and it is being marked as isEnd
				//means that the word already exists in trie
			}
			else {
				//if that's not the case then mark it end
				parent.isEnd = true;
				noOfWords++;		
			}
			return;
		}
		
		char firstChar = words.charAt(0);
		String remainingString = words.substring(1);
		Node child = parent.children.get(firstChar);// getting the child from parent's HashMap
		
		if(child == null) {
			//if it is null then we have to create a new child and add it to parent's hashMap
			child = new Node(firstChar);
			parent.children.put(firstChar, child);
		}
		
		//now make recursive call of addWord as we have to add other characters of the word
		addWord(child,remainingString);
		
	}
	
	boolean search(Node parent, String words) {
		
		if(words.length() == 0) {
			return parent.isEnd; //this will take care it other characters also exist in HashMap and our word is smaller than that.
			//if it is isEnd then true else false
		}
		
		char firstChar = words.charAt(0);
		String remainingString = words.substring(1);
		Node child = parent.children.get(firstChar);// getting the child from parent's HashMap
		
		if(child == null) {
			//if it is null then the word doesn't exists
			return false;
		}
		
		//now make recursive call of addWord as we have to add other characters of the word
		return search(child,remainingString);
	}
	
//	boolean remove(Node parent , String word) {
//		
//	}
	
	void print(Node parent, String word) {
		
		if(parent.isEnd) {
			System.out.println(word);//this will print whole word
			//we are not returning anything as we want other words too. Return will make this function display only one word
		}
		
		for(Map.Entry<Character,Node> map: parent.children.entrySet()) { //Map.Entry gives all the key,Value pairs
			//recursively call print as we have to print the word not just characters
			print(map.getValue(), word + map.getKey());
			//map.getValue() is Node and Key is the Characters which we have added
		}
	}
}



public class TriesDemo {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord(trie.getRoot(), "abhishek");
		trie.addWord(trie.getRoot(), "amit");
		trie.addWord(trie.getRoot(), "amitesh");
		trie.addWord(trie.getRoot(), "amresh");
		trie.addWord(trie.getRoot(), "rishab");
		trie.addWord(trie.getRoot(), "rakesh");
		
		trie.print(trie.getRoot(),"");
		
		String result = trie.search(trie.getRoot(), "abhishek")?"Found":"Not Found";
		System.out.println(result);

	}

}
