package Graphs;

import java.util.ArrayList;
import java.util.List;

public class RepresentationOfGraph {
	
	/*
	 * Graphs are represented in two forms
	 * 1. Adjacency Matrix
	 * 		a) Directed Graph - Aij = A[i,j], 1 -> if Edges present , 0 -> if Edge not present
	 * 		b) Undirected Graph - Gives symmetric Matrix i.e. A[i,j] = A[j,i]
	 * 		c) Takes large memory of nxn as its a matrix
	 * 2. Adjacency List
	 * 		It contains a simple array of all the vertices &
	 * 		in this array there exists either ArrayList or LinkedList of it's connections to it's neighbours
	 * 		Takes less memory space than Adjacency Matrix i.e. (n+m)
	 */

	public static void main(String[] args) {
		int arr[][] = {{0,1},{1,2},{2,0},{1,3}};  //adjacency matrix
		System.out.println(arr); //gives output as [[I
		
		//given above is the adjacency Matrix and thus we will convert it into adjacency list
		List<List<Integer>> mainList = new ArrayList<>(); //adjacency list
		for(int i = 0; i<arr.length; i++) {
			List<Integer> subList = new ArrayList<>();
			subList.add(arr[i][0]);
			subList.add(arr[i][1]);
			mainList.add(subList);
		}
		
		Graph graph = new Graph();
		for(int i=0; i<arr.length; i++) {
			graph.addVertex(String.valueOf(i));//adding vertices of graph
		}
		for(List<Integer> sub: mainList) { //i.e. extracting subLists from the mainList
			String firstVertex = sub.get(0).toString();
			String secondVertex = sub.get(1).toString();
			graph.addEdge(firstVertex, secondVertex, 1);
		}
		
		graph.print();
		

	}

}
