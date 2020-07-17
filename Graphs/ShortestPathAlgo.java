package Graphs;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * 3 main shortest path algo
 * 
 * 1. Greedy Algo - DP problem
 * 2. Prim's Algo
 * 3. Kruskal Algo
 * 
 * For that find out Minimum Spanning Tree(MST) first:
 * 		a) Cover all vertices (N)
 * 		b) There should be (n-1) edges covered
 * 		c) Minimum cost
 */
class ShortestPath extends Graph {

	//prims algorithm
	
	/* For that we will create a PrimsPair
	 * PrimsPair contains - 1. VertexName, 2. AcquireFrom, 3. Cost
	 * Aim is to generate a MST which is a graph
	 * we will maintain a Heap which will hold all the PrimsPair
	 * At first the PrimsPair will have (acquireFrom = null and cost = Integer.Max)
	 * So from the Vertices Map we will start adding every vertex into Heap in form of PrimsPair
	 * Side by side we'll make an entry into another Map.(this will be used to prevent cycle)
	 * This map will contain the vertexName as key and address to PrimsPair corresponding to vertexName as value.
	 * After we have added both in Heap and Map, we will take first element from heap, extract its vertexName and 
	 *    based on that we will explore the neighbours and make edges based on the minimal cost and later form MST
	 * Note:: Changing value of cost in Heap element PrimsPair, it will have no effect on Heap as it does not understand Update Method
	 * 		  Heap only have 'Add' and 'Remove' method and based on Add method it will uphepify and downheapify
	 * To upHeapify use Comparator in PriorityQueue which is pre defined class for Heap.
	 *
	 */
	
	class PrimsPair{
		String vertexName;
		String acquireFrom;
		int cost;
	}
	
	
	Graph prims() {
		Graph mst = new Graph();
		HashMap<String, PrimsPair> map = new HashMap<>();
		
		//min Heap
		PriorityQueue<PrimsPair> heap = new PriorityQueue<>((first, second) -> first.cost - second.cost);//argume
		
		//adding all the vertices into the Heap in form of PrimsPair
		for(String key: vertices.keySet()) {
			
			PrimsPair newPair = new PrimsPair();
			newPair.vertexName = key;
			newPair.acquireFrom = null; //by default it is null
			newPair.cost = Integer.MAX_VALUE;
			heap.add(newPair);
			map.put(key,newPair);
			
		}//added all the vertices in heap as well as HashMap
		
		while(!heap.isEmpty()) {
			
			PrimsPair p = heap.remove();
			map.remove(p.vertexName);
			
			if(p.acquireFrom == null) {
				//which means this has come for the first time
				mst.addVertex(p.vertexName);
			}
			else {
				mst.addVertex(p.vertexName);
				mst.addEdge(p.vertexName, p.acquireFrom, p.cost); //we can add second argument as p will have acquireFrom as it has been checked
			}
			//now its time to get the neighbours
			/*
			 * NeighbourVertex objVertex = vertices.get(p.vertexName); HashMap<String,
			 * Integer> m = objVertex.neighbour; Set<String> keys = m.keySet(); for(String
			 * key: keys)
			 */
			
			for(String neighbour : vertices.get(p.vertexName).neighbour.keySet()) {
				if(map.containsKey(neighbour)) { //as visited vertex has been removed from the map
					//this check will give only the unvisited vertices thus preventing cycle
					
					int oldCost = map.get(neighbour).cost; //map will give the reference of Heap
					int newCost = vertices.get(p.vertexName).neighbour.get(neighbour); //cost between eg. A -> B
					
					if(newCost<oldCost) {
						//p2.cost = newCost; //this will not work as Heap will not know about updation it doen't have that feature
						PrimsPair p2 = map.get(neighbour);
						PrimsPair p3 = new PrimsPair(); //we did this to re add in Heap to upheapify as Heap does not have update feature
						p3.vertexName = p2.vertexName;
						p3.acquireFrom = p.vertexName; //as p3 has been acquired from the top daddy PrimsPair p
						p3.cost = newCost;
						
						heap.remove(p2);
						heap.add(p3);
						map.put(neighbour,p3); //as after removing p2 the address will change as we did her update operation
					}
					
				}
			}
		}
		
		
		
		return mst;
	}

}

public class ShortestPathAlgo{
	public static void main(String[] args) {
		ShortestPath graph = new ShortestPath();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 6);
		graph.addEdge("B", "C", 3);
		graph.addEdge("D", "C", 1);
		graph.addEdge("D", "E", 8);
		graph.addEdge("E", "F", 5);
		graph.addEdge("E", "G", 7);
		graph.addEdge("F", "G", 4);
		System.out.println("****************Prims Output**********************");
		graph.prims().print();
	}
	
}

