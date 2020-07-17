package Heap;

import java.util.ArrayList;

/*
 * Also known as Priority Queue
 * Meaning same as queue but the adding of children will happen priority wise
 * Priority - 1. Max 2. Min
 * Therefore two types of Heap  - 1. MinHeap 2. MaxHeap
 * Two bare Minimum conditions of Heap
 * 1. Complete Binary Tree
 * 2. Min/Max Heap
 * 
 * Complete Binary tree - Tree whose (n-1) elements are completely filled whereas nth level left should be completely filled
 * while right can or cannot be
 * i.e. left is mandate while right leafs are optional for the nth level.
 * 
 * Full binary tree - where all the levels are completely filled
 * 
 * TC of Queue for Sorted Array - 
 * 		Adding in last - O(1)
 * 		Insert at beginning. - O(N) as elements have to shift
 * 		Delete from beginning - O(N) 
 * 		Get Data at minimum element - O(1) while O(N) for unsorted Array
 * 
 * TC of Heap
 * 		InsertAt Beginning - logN
 * 		Delete from Beginning - logN
 * 		Get Data at minimum element - O(1)
 * 		
 */

class Heap{
	
	ArrayList<Integer> data = new ArrayList<>();
	
	void add(int item) {
		//adding all the item we get directly to the arrayList
		data.add(item);
		
		//now checking the current item which is child with its parent using the lci rci formula. 
		//current index will be the index of last added item into arrayList
		
		upHeapify(data.size()-1);
	}
	
	private void upHeapify(int childIndex) {
		//lci = left child index = (parentIndex -1)/2
		//rci = right child index = (parentIndex - 2)/2
		
		int parentIndex = (childIndex - 1)/2;
		
		//10<10 or 20<20 when childIndex given is 0
		if(data.get(childIndex)<data.get(parentIndex)) {//it also acts as the base case of recursion
			swap(childIndex,parentIndex);
			//now we have to check again with its parent whether it is small or not
			//so for next cycle parentIndex becomes childIndex
			//and there will be sometime when childIndex value will be greater than parentIndex value, there will the recursion end
			upHeapify(parentIndex);
		}
	}
	
	private void swap(int childIndex, int parentIndex) {
		int parentValue = data.get(parentIndex);
		int childValue = data.get(childIndex);
		data.set(parentIndex, childValue);
		data.set(childIndex, parentValue);
	}
	
//	private void print() { //as it was private it wasn't visible from the main via object also. But other methods in this class can call this method
	void print() {
		for(Integer i: data) {
			System.out.println("Value: "+i);
		}
	}
	
	int delete() {
		/*
		 * 1. Swap first element with the last element, as we are deleting the first element either from min heap or max heap
		 * 2. Store the last element in some variable so as to return and display the deleted element
		 * 3. Remove the last element from the ArrayList
		 * 3. Now do the downHeapify
		 */
		swap(0, data.size()-1); //swapping first and last element
		int deletedValue = data.remove(data.size()-1);//deleting the last element which was first element at a point
		downHeapify(0);
		
		return deletedValue;
		
		
	}
	
	void downHeapify(int parentIndex) {
		/*
		 * 1. From the parent index calculate the values at right and left index using the lci and rci
		 * 2. check whether the rci is greater than parent or lci
		 * 3. i.e. data[lci] < data[parentIndex] or data[rci] < data[parentIndex]
		 * 4. This will have one benefit that we will do opetation in one part of the tree and thats why TC for deletion is logN
		 * 5. Swap the elements 
		 * 6. Till it forms the Heap and CBT recursively call downHeapify
		 */
		
		int lci = 2 * parentIndex + 1;
		int rci = 2 * parentIndex + 2;
		
		int minIndex = parentIndex;
/*		
 		Approach 1
 		
		if(lci>data.size()-1 || rci>data.size()-1)
			return;
		
		int childIndex;
		
		
		if(data.get(lci) < data.get(parentIndex))
			minIndex = lci;			
		else if(data.get(rci) < data.get(parentIndex))
			minIndex = rci;
		else
			return;
			
		if(data.get(minIndex)<data.get(parentIndex)) {
			swap(minIndex,parentIndex);
			downHeapify(minIndex);
		}	
		
*/
		
		//Approach 2
		
		if(lci<data.size()-1 && data.get(lci) < data.get(parentIndex))
			minIndex = lci;
		if(rci<data.size()-1 && data.get(rci) < data.get(parentIndex))
			minIndex = rci;
		
		if(minIndex != parentIndex) {
			swap(minIndex,parentIndex);
			downHeapify(minIndex);
		}
		
	}
}


public class HeapDemo {
	
	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.add(20);
		heap.add(10);
		heap.add(30);
		heap.add(5);
		heap.add(15);
		heap.add(25);

		heap.print();
		
		int value = heap.delete();
		System.out.println("**************After delete of: " + value +" ******************");
		heap.print();
	}

}
