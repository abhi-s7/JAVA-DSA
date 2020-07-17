package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/* 
 * 1. Graphs(Vertices, Edges)
 * 2. Nodes are vertices and link between them are edges
 * 3. Two types - 1. Directed [eg. Twitter] 2. Undirected [eg. Facebook]
 * 4. Edges contains cost factor
 * 5. Generation of Graphs
 * 		a) Create HashMap of vertices [key - vertex] & [Value - reference of Neighbor class]
 * 		b) Neighbor class contains a HashMap [key - neighbor vertices] & [value-cost]
 * 		c) Total Vertices - size of first HashMap
 * 		d) Total edges - (size of second HashMap)/2 - because links are duplicates eg. A-B, B-A
 * 
 * 
 * 
 */

class NeighbourVertex{
	HashMap<String, Integer> neighbour = new HashMap<>();
}

class Graph{
	HashMap<String, NeighbourVertex> vertices = new HashMap<>();
	
	public int countVertices() {  //this counts the total number of Vertices present i.e. size of first HashMap
		return vertices.size();
	}
	
	//check if the vertex exists or not
	public boolean isVertexExist(String vertexName) {
		if(vertices.containsKey(vertexName)) {
			return true;
		}
		
		return false;
	}
	
	//add vertex
	public void addVertex(String vertexName) {
		//at starting neighbours  will be empty therefore we create HashMap and add it's reference to the value of first HashMap[vertices]
		NeighbourVertex neighbourVertex = new NeighbourVertex();
		vertices.put(vertexName, neighbourVertex); //added vertex name and reference to the neighbouring vertices HashMap
		
	}
	
	public void removeVertex(String vertexName) {
		NeighbourVertex vertex = vertices.get(vertexName);//this is to check whether given vertex actually exists in HashMap
		
		if(vertex == null) {
			System.out.println("Given vertex doen't exists :(");
			return;
		}
		
//		ArrayList<String> vertexList = new ArrayList<>(vertices.keySet());//this method does it's job but we have to initialize it with new key word and pass hashmap in its argument
		//vertices.keySet() returns a Set so why not use Set directly
		Set<String> vertexSet = vertices.keySet();
		
		for(String key: vertexSet) {
			NeighbourVertex tempVertex = vertices.get(key);
			if(tempVertex != null) { //no need to check this as key is being get from HashMap itself 
//				if(tempVertex.neighbour.containsKey(vertexName)) { //no need to check as HashMap doesn't give null pointer exception when we try to delete null key
//					tempVertex.neighbour.remove(vertexName);
//				}
				tempVertex.neighbour.remove(vertexName);

			}
		}
		
		vertices.remove(vertexName); //now removing the vertex from main HashMap after removing it's reference from it neighbour
		
		
		
	}
	
	//supporting methods to add edges
	public int noOfEdges() {
		ArrayList<String> keys = new ArrayList<>(vertices.keySet()); //this will hold all the keys i.e. vertices from HashMap
		int count = 0;
		for(String key: keys) {
			NeighbourVertex currentVertex = vertices.get(key); //get(key) gives reference of NeighBourVertex class and we store it in NeighBourVertex object
			count+= currentVertex.neighbour.size();
		}
		
		return count/2;
	}
	
	//to check if edges already exists or not
	public boolean isEdgeExist(String firstVertex, String secondVertex) {
		
//		if(vertices.containsKey(firstVertex)) {
//			NeighbourVertex currentVertex = vertices.get(firstVertex);
//			if(currentVertex.neighbour.containsKey(secondVertex)) {
//				return true;
//			}
//			
//		}//but i have to check for both of the vertices so this code is not optimized
		
		NeighbourVertex firstVertexObj = vertices.get(firstVertex);
		NeighbourVertex secondVertexObj = vertices.get(secondVertex);
		
		if(firstVertexObj == null || secondVertexObj == null ||				//we have to check in vertices HashMap for both the vertices
				!firstVertexObj.neighbour.containsKey(secondVertex)) {		//then check that if first vertex contains has neighbour of secondVertex
			return false;
		}
		return true;
		
	}
	
	public void addEdge(String first, String second, int cost) {
		if(isEdgeExist(first,second)) {
			System.out.println("Edge already exists b/w " + first + " and " + second);
			return;
		}
		
		NeighbourVertex firstVertex = vertices.get(first);
		NeighbourVertex secondVertex = vertices.get(second);
		
		if(firstVertex!=null && firstVertex!=null) {
			firstVertex.neighbour.put(second, cost);
			secondVertex.neighbour.put(first, cost);
		}else {
			System.out.println("Either of the vertex is empty");
		}
	}
	
	public void removeEdge(String first, String second) {
		if(!isEdgeExist(first,second)) {
			System.out.println("Edge does not exist so cannot delete the edge :(");
			return;
		}
		
		NeighbourVertex firstVertex = vertices.get(first);
		NeighbourVertex secondVertex = vertices.get(second);
		
		firstVertex.neighbour.remove(second);
		secondVertex.neighbour.remove(first);
		
		if(!firstVertex.neighbour.containsKey(second) && !secondVertex.neighbour.containsKey(first)) {
			System.out.println("Edge removed successfully :)");
		}
	}
	
	public void isPathExist2(String source, String destination,String result, HashMap<String, Boolean> isVisited ) {
		
		isVisited.put(source,true);
		result+=source;
		
		if(source.equals(destination)) {
			System.out.println("Path is: " + result);
			return;
		}
		
		
		NeighbourVertex sourceV = vertices.get(source);
		Set<String> keys = sourceV.neighbour.keySet();
		for(String key : keys) {
			if(isEdgeExist(source,key)) {
				if(!isVisited.containsKey(key)) {
				
					isPathExist2(key, destination, result, isVisited);
				}
					
			}
		}

	}
	
	boolean isPathExist(String source, String destination, HashMap<String, Boolean> isVisited) {
		//set the source to visited map
		isVisited.put(source,true); //this prevent cycle in path
		
		//we will check prior that weather the edge exists b/w source and destination or not
		if(isEdgeExist(source,destination)) {
			return true;
		}
		
		//if thats not the case
		NeighbourVertex neighboursVertex = vertices.get(source);
		//we'll get all the keys using this object
		Set<String> neighbours = neighboursVertex.neighbour.keySet();
		
		for(String neighbour : neighbours) {
			
			//we will check whether the source is already marked or not
			//second we will check whether path between neighbour and destination exists or not
			//i.e. we will do recursion here 
			if(!isVisited.containsKey(neighbour) && isPathExist(neighbour,destination,isVisited)) {//tail recursion
				//if they both are true
				return true;
			}
			
//			//above code is same as below
//			if(!isVisited.containsKey(neighbour)) {
//				if(isPathExist(neighbour,destination,isVisited)) {  //isPathExist will return true or false based on that it will return value
//					return true;
//				}
//			}
			
		}
		
		//else
		return false;
		
	}
	
	/*
	 * BFS  - Breadth First Search. With Breadth meaning it is Width.
	 * 		- Level order traversal
	 * 		- Traverse in distance0, then distance 1, then distance 2 --> First it will connect from source to it's neighbouring(distance 1) nodes 
	 * 			then further they connect with their neighbours i.e. distance 2
	 * 		- Advantage - Gives Shortest Path
	 * 
	 * DFS  - Depth first search
	 * 		- It reaches to the depth of left node then move towards right
	 * 		- This process takes time in finding the desired node
	 */
	
	public boolean bfs(String source, String destination) {
		
		HashMap<String, Boolean> visitedMap = new HashMap<>();
		
		LinkedList<Pair> queue = new LinkedList<>();//LinkedList in Java has predefined features to act as queue as well as stack
		Pair pair = new Pair();
		pair.vertexName = source;
		pair.placeTill = source;
		
		queue.addLast(pair);
		
		while(!queue.isEmpty()) {
			Pair p = queue.removeFirst(); //removing first element from the queue
			
			if(visitedMap.containsKey(p.vertexName)) {
				continue;
			}
			
			//if not then add it to visitedMap and check for link b/w vertex and destination
			visitedMap.put(p.vertexName,true); //placing the element to visited map
			
			
			if(isEdgeExist(p.vertexName,destination)) {
				return true;
			}
			
			//if that's not the case then we take neighbours of that vertexName
			NeighbourVertex vertex = vertices.get(p.vertexName);
		
			Set<String> neighbours = vertex.neighbour.keySet();
			
			for(String neighbour: neighbours) {	
				if(!visitedMap.containsKey(neighbour)){ //this prevents the cycle in the graph
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.placeTill = p.placeTill + neighbour;
					queue.addLast(newPair);
				}
				
			}			
			
		}
		//if in the whole cycle of link is not found then path is false
		return false;
		
		
	}
	
	/*
	 *  DFS - Depth first search
	 *  	- Maintains stack
	 *  	- thus recursion is based on DFS eg. permutation, combination, backtracking questions all are based on dfs
	 *  	- Tree traversal is also based on DFS eg. pre order, post order, in order
	 *  	- Add and remove from same position. i.e. adding and removing from first
	 */
	
	public boolean dfs(String source, String destination) {
		
		HashMap<String, Boolean> visitedMap = new HashMap<>();
		
		LinkedList<Pair> stack = new LinkedList<>();//LinkedList in Java has predefined features to act as queue as well as stack
		Pair pair = new Pair();
		pair.vertexName = source;
		pair.placeTill = source;
		
		stack.addFirst(pair);
		
		while(!stack.isEmpty()) {
			Pair p = stack.removeFirst(); //removing first element from the queue
			
			if(visitedMap.containsKey(p.vertexName)) {
				continue;
			}
			
			//if not then add it to visitedMap and check for link b/w vertex and destination
			visitedMap.put(p.vertexName,true); //placing the element to visited map
			
			
			if(isEdgeExist(p.vertexName,destination)) {
				return true;
			}
			
			//if that's not the case then we take neighbours of that vertexName
			NeighbourVertex vertex = vertices.get(p.vertexName);
		
			Set<String> neighbours = vertex.neighbour.keySet();
			
			for(String neighbour: neighbours) {	
				if(!visitedMap.containsKey(neighbour)){ //this prevents the cycle in the graph
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.placeTill = p.placeTill + neighbour;
					stack.addFirst(newPair);
				}
				
			}			
			
		}
		//if in the whole cycle of link is not found then path is false
		return false;
		
		
	}
	
	
	/*
	 *  BFT - Breadth first traversal
	 * 		- Here we are printing the path of the traversal
	 * 		- 
	 */
	
	public boolean bft(String source, String destination) {
		
		HashMap<String, Boolean> visitedMap = new HashMap<>();
		
		LinkedList<Pair> queue = new LinkedList<>();//LinkedList in Java has predefined features to act as queue as well as stack
		Pair pair = new Pair();
		pair.vertexName = source;
		pair.placeTill = source;
		
		queue.addLast(pair);
		
		while(!queue.isEmpty()) {
			Pair p = queue.removeFirst(); //removing first element from the queue
			
			if(visitedMap.containsKey(p.vertexName)) {
				continue;
			}
			
			//if not then add it to visitedMap and check for link b/w vertex and destination
			visitedMap.put(p.vertexName,true); //placing the element to visited map
			
			System.out.println(p.vertexName + " " + p.placeTill);
			if(isEdgeExist(p.vertexName,destination)) {
				System.out.println(destination); //i.e. we have reached to the last vertex
				return true;
			}
			
			//if that's not the case then we take neighbours of that vertexName
			NeighbourVertex vertex = vertices.get(p.vertexName);
		
			Set<String> neighbours = vertex.neighbour.keySet();
			
			for(String neighbour: neighbours) {	
				if(!visitedMap.containsKey(neighbour)){ //this prevents the cycle in the graph
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.placeTill = p.placeTill + neighbour;
					queue.addLast(newPair);
				}
				
			}			
			
		}
		//if in the whole cycle of link is not found then path is false
		return false;
		
		
	}

	class Pair{
		String vertexName;
		String placeTill;
	}
	
	
public boolean bftPrint(String source, HashMap<String, Boolean> visitedMap) {
		
//		visitedMap = new HashMap<>();
		
		LinkedList<Pair> queue = new LinkedList<>();//LinkedList in Java has predefined features to act as queue as well as stack
		Pair pair = new Pair();
		pair.vertexName = source;
		pair.placeTill = source;
		
		queue.addLast(pair);
		
		while(!queue.isEmpty()) {
			Pair p = queue.removeFirst(); //removing first element from the queue
			
			if(visitedMap.containsKey(p.vertexName)) {
				continue;
			}
			
			//if not then add it to visitedMap and check for link b/w vertex and destination
			visitedMap.put(p.vertexName,true); //placing the element to visited map
			
			System.out.println(p.vertexName + " " + p.placeTill);
//			if(isEdgeExist(p.vertexName,destination)) {
//				System.out.println(destination); //i.e. we have reached to the last vertex
//				return true;
//			}
			
			//if that's not the case then we take neighbours of that vertexName
			NeighbourVertex vertex = vertices.get(p.vertexName);
		
			Set<String> neighbours = vertex.neighbour.keySet();
			
			for(String neighbour: neighbours) {	
				if(!visitedMap.containsKey(neighbour)){ //this prevents the cycle in the graph
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.placeTill = p.placeTill + neighbour;
					queue.addLast(newPair);
				}
				
			}			
			
		}//while ends
		
		if(visitedMap.size() < vertices.size()) {
			Set<String> allElements = vertices.keySet();
			for(String check : allElements) {
				
				if(!visitedMap.containsKey(check)) {
					System.out.println("*************************************");
					bftPrint(check,visitedMap);//for second E will pass
				}
			}
		}
		//if in the whole cycle of link is not found then path is false
		return false;
		
		
	}

//*******************BFT detect cycle*************************************

public boolean detectCycle(String source, String destination) {
	
	HashMap<String, Boolean> visitedMap = new HashMap<>();
	
	LinkedList<Pair> queue = new LinkedList<>();//LinkedList in Java has predefined features to act as queue as well as stack
	Pair pair = new Pair();
	pair.vertexName = source;
	pair.placeTill = source;
	
	queue.addLast(pair);
	
	while(!queue.isEmpty()) {
		Pair p = queue.removeFirst(); //removing first element from the queue
		
		if(visitedMap.containsKey(p.vertexName)) {
			//continue; //this will prevent from processing further if the vertex already has been processed
			//therefore if it moves in this condition then there is loop in the graph
			
			return true;
		}
		
		//if not then add it to visitedMap and check for link b/w vertex and destination
		visitedMap.put(p.vertexName,true); //placing the element to visited map
		
		System.out.println(p.vertexName + " " + p.placeTill);
		if(isEdgeExist(p.vertexName,destination)) {
			System.out.println(destination); //i.e. we have reached to the last vertex
			return true;
		}
		
		//if that's not the case then we take neighbours of that vertexName
		NeighbourVertex vertex = vertices.get(p.vertexName);
	
		Set<String> neighbours = vertex.neighbour.keySet();
		
		for(String neighbour: neighbours) {	
			if(!visitedMap.containsKey(neighbour)){ //this prevents the cycle in the graph
				Pair newPair = new Pair();
				newPair.vertexName = neighbour;
				newPair.placeTill = p.placeTill + neighbour;
				queue.addLast(newPair);
			}
			
		}			
		
	}
	//if in the whole cycle of link is not found then path is false
	return false;
	
}
//*******************BFT detect cycle*************************************

//*******************BFT isConnected**************************************

public boolean isConnected() {
	
	HashMap<String, Boolean> visitedMap = new HashMap<>();
	
	LinkedList<Pair> queue = new LinkedList<>();//LinkedList in Java has predefined features to act as queue as well as stack
	int visitedCount = 0;
	
	for(String key: vertices.keySet()) {
		//this for loop will used so as to make behave all the vertices of graph as source
		
//**********************************************************
		if(visitedMap.containsKey(key)) {
			continue; //this will prevent from recalculating all the visited Vertices
		}
		visitedCount++;
//**********************************************************

		Pair pair = new Pair();
		
//**********************************************************
		pair.vertexName = key;
		pair.placeTill = key;
//**********************************************************
		
		queue.addLast(pair);
		
		while(!queue.isEmpty()) {
			Pair p = queue.removeFirst(); //removing first element from the queue
			
			if(visitedMap.containsKey(p.vertexName)) {
				continue;
			}
			
			//if not then add it to visitedMap and check for link b/w vertex and destination
			visitedMap.put(p.vertexName,true); //placing the element to visited map
					
			//if that's not the case then we take neighbours of that vertexName
			NeighbourVertex vertex = vertices.get(p.vertexName);
		
			Set<String> neighbours = vertex.neighbour.keySet();
			
			for(String neighbour: neighbours) {	
				if(!visitedMap.containsKey(neighbour)){ //this prevents the cycle in the graph
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.placeTill = p.placeTill + neighbour;
					queue.addLast(newPair);
				}
				
			}			
			
		}
	
	}
	
	return visitedCount == 1; //i.e. if there exists only one graph not other components
	
}

//*******************BFT isConnected**************************************

	
	void print() {
		for(Map.Entry<String, NeighbourVertex> v: vertices.entrySet()) {
			System.out.println(v.getKey() + " => " + v.getValue().neighbour);
		}
	}
}

public class GraphDemo {	
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		System.out.println("*************Total Vertices: " + graph.countVertices() + " ***********************");
		
		graph.addEdge("A", "B", 3);
		graph.addEdge("A", "D", 2);
		graph.addEdge("B", "C", 4);
		graph.addEdge("D", "C", 7);
		graph.addEdge("D", "E", 2);
		graph.addEdge("E", "F", 8);
		graph.addEdge("E", "G", 9);
		graph.addEdge("F", "G", 10);
		
		
		graph.print();
		
		System.out.println("*************Total Edges: " + graph.noOfEdges() + " ***********************");
		
		graph.removeEdge("D", "E");// after removing link between D & E result gives false
		graph.removeEdge("F", "G");
		graph.removeEdge("E", "G");
		
//		boolean result = graph.isPathExist("A", "E",new HashMap<String,Boolean>());
//		System.out.println("Path exist: " + result);
			
		boolean result = graph.bfs("A", "E");
		System.out.println("Path exists: " + result);
		
		System.out.println("#################################BFT Print################################");
		//graph.bftPrint("A", new HashMap<String, Boolean>());
		System.out.println("Is graph connected: " + graph.isConnected()); //this will check whether the Graph is connected or not
		
		//graph.isPathExist2("A", "E","",new HashMap<String,Boolean>());
		
//		System.out.println("*************After Removing Edges***********************");
//		
//		graph.removeEdge("F", "G");
//		graph.print();
//		
//		System.out.println("*************After Removing Vertex***********************");
//		graph.removeVertex("E");
//		graph.print();
		

		
	}
	
}
