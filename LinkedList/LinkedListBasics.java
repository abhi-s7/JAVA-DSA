package LinkedList;

public class LinkedListBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Operations.addNode(1001, "RAM");
		Operations.addNode(1002, "Shyam");
		Operations.addNode(1003, "Mohan");
		Operations.addNode(1004, "Sohan");
		Operations.addNode(1005, "Rohan");

		Operations.print();
		
		System.out.println("*****************After first print************************");
		int pos = 2;
		
		Emp emp = new Emp(1009, "Tim");
	
		Operations.insertAtPosition(new NodeB<Emp>(emp), pos - 1);
		
		Operations.print();
	}

}

class Emp{
	int id;
	String name;
	
	Emp(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ID:" + id + " Name: " + name;
	}
}

class NodeB<T>{
	T data;
	
	NodeB<T> next; //next is instance that is pointing to itself
	
	NodeB(T data){
		this.data = data;
		this.next = null;
	}
}

class Operations{
	static NodeB<Emp> start; //if this was local then it gave warning to initialize it
	
	static void addNode(int id, String name) {
		
		Emp emp = new Emp(id, name);
		
		NodeB<Emp> node = new NodeB<Emp>(emp);
		
		if(start == null) {
			start = node;
		}
		else {
			NodeB<Emp> temp = start;
			
			while(temp.next != null) { //temp.next will give last node while temp will be the end
				temp = temp.next;
			}
			temp.next = node;
		}
		
	}
	
	static void insertAtBeg(NodeB<Emp> node) {
		if(start == null) {
			start = node;
			return;
		}
		
		node.next = start;
		start = node;
		
	}
	//insert at end
	static void insertAtEnd(NodeB<Emp> node) {
		//no node present
		if(start == null) {
			start = node;
			return;
		}
		
		//only one node present
		if(start.next == null) {
			start.next = node;
			node.next = null;
			return;
		}
	}
	
	static void insertAtPosition(NodeB<Emp> node,int position) {
		if(start == null) {
			start = node;
			return;
		}
		
		if(position == 0) {
//			Node<Emp> temp = start;
			node.next = start;
			start = node;
			
		}
		
		if(position>0) {
			NodeB<Emp> temp = start;
			
			int i = 1;
			while(i<position) {
				temp = temp.next;
				i++;
			}
			node.next = temp.next;
			temp.next = node;
			
		}
	}
	
	static void print() {
		NodeB<Emp> temp = start;
		
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		
	}
}







