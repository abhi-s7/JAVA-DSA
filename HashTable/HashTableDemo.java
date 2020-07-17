package HashTable;

// hashMap should be made by linkedList
class HashMap<K,V>{
	
	// we are creating "buckets array" of type "LinkedList" which will have "KeyValuePair" which further will have K&V
	LinkedList<KeyValuePair<K,V>> buckets[];
//	int arr[] = new int[5];
	
	static final int DEFAULT_CAPACITY = 10;
	int size; // to track the size of bucket. If it crosses the size then we double it
	HashMap(int capacity){
		buckets = new LinkedList[capacity];
	}
	
	HashMap(){
		this(DEFAULT_CAPACITY);  // ctrl + click on "this" it will take to the above HashMap(int capacity)
						//this means when default constructor is called it will call the parameterized
					//constructor with DEFAULT_CAPACITY
	}
	
	void print() {
		for(LinkedList<KeyValuePair<K,V>> bucket : buckets) {
		if(bucket!=null) {
			bucket.print();
		}
	}
	}
	
	private void rehashing() {
		double lambda = (size * 0.75)/buckets.length;
		if(lambda>2) {
			rehash();
		}
	}
	
	private void rehash() {
		LinkedList<KeyValuePair<K,V>> backupArr[] = buckets; //backing up the buckets array so that we can increase the size of buckts
		buckets = new LinkedList[2*backupArr.length];
		
		size = 0;
		
		for(LinkedList<KeyValuePair<K,V>> bucket: backupArr) {
			/*
			 * here we are taking the LinkedList from the backupArr which is backup of buckets 
			 * Then we remove the first node form the LinkedList, extract its key value and put it in buckets of new size
			 * This will generate the new index due to new length in Hash function.
			 * When first node is removed then start of the LinkedList shifts to next so we are maintaining while loop until its size is 0
			 * This whole process is repeated until all the elements are re placed into new buckets from the backupArr
			 */
			
			if(bucket!=null) {
				while(bucket.getSize()!=0) {
					KeyValuePair<K,V> pair = bucket.removeAt(0);
					put(pair.key,pair.value);
				}
				
			}
			
		}
		
		
	}
	
	V put(K key, V value) 
	{
		int bucketIndex = hashFunction(key);
		LinkedList<KeyValuePair<K,V>> bucket = buckets[bucketIndex];
		KeyValuePair<K,V> keyValuePair = new KeyValuePair<>(key, value);

//		Node<KeyValuePair<K,V>> node = new Node<>(keyValuePair);
			
		if(bucket == null) {
			bucket = new LinkedList<>(); //creating a linkedList earlier was null
			//bucket.addInLast(node);   // we can send node as argument instead of data
			bucket.addInLast(keyValuePair); //here keyValuePair is data
			buckets[bucketIndex] = bucket; //we have to add this LinkedList reference into the bucket array else it will be null next time
										//because we haven't set the linkage
			size++;
		}else {
			int index = bucket.search(keyValuePair);
			//if index is 0 i.e. we didn't find the key in the list so add the node in last
			if(index == -1) {
				bucket.addInLast(keyValuePair);
				size++;
			}
			else {
				KeyValuePair tempKV = bucket.getAtIndex(index); //i.e. getting same key at particular index
				tempKV.value = value; //replacing the new value with existing
			}
		}
		
		return value;
	}
	
	V get(K key) {
		
		int bucketIndex = hashFunction(key);
		LinkedList<KeyValuePair<K,V>> bucket = buckets[bucketIndex];
		//i.e. generating the index from the hash function to search the bucket in the array of buckets which holds all the LL
		if(bucket == null) {
			return null;
		}else {
			KeyValuePair<K,V> keyValuePair = new KeyValuePair<>(key,null);// as value is null and we require keyValuePair object to search in LL
			int index = bucket.search(keyValuePair); //searching in the LL for the pair
			if(index == -1) {
				return null;
			}
			else {
				//the key exist in LL
				KeyValuePair tempKV = bucket.getAtIndex(index);
				return (V) tempKV.value;
			}
		}
		
	}
	
	boolean containKey(K key) {
		
		int bucketIndex = hashFunction(key);
		LinkedList<KeyValuePair<K,V>> bucket = buckets[bucketIndex];
		//i.e. generating the index from the hash function to search the bucket in the array of buckets which holds all the LL
		if(bucket == null) {
			return false;
		}else {
			KeyValuePair<K,V> keyValuePair = new KeyValuePair<>(key,null);// as value is null and we require keyValuePair object to search in LL
			int index = bucket.search(keyValuePair); //searching in the LL for the pair
			if(index == -1) {
				return false;
			}
			else {
				//the key exist in LL
				return true;
			}
		}
		
	}
	
	V delete(K key) {
		int bucketIndex = hashFunction(key);
		LinkedList<KeyValuePair<K,V>> bucket = buckets[bucketIndex];
		//i.e. generating the index from the hash function to search the bucket in the array of buckets which holds all the LL
		if(bucket == null) {
			return null;
		}else {
			KeyValuePair<K,V> keyValuePair = new KeyValuePair<>(key,null);// as value is null and we require keyValuePair object to search in LL
			int index = bucket.search(keyValuePair); //searching in the LL for the pair
			if(index == -1) {
				return null;
			}
			else {
				//the key exist in LL
				KeyValuePair tempKV = bucket.getAtIndex(index);
				bucket.deleteNode(tempKV);
				size--;
				return (V) tempKV.value;
			}
		}
	}
	
	//receive key from put method & return bucketIndex
	private int hashFunction(K key) {
		int hashCode = Math.abs(key.hashCode()); // Math.abs(a) because sometimes the hashcode is negative which will create ArrayIndexOutOfBound Exception
		int bucketIndex = hashCode % buckets.length;  //this will give remainder from 0 to (buckets.length -1)
		
		//System.out.println("bucket Index: " + bucketIndex);
		
		return bucketIndex;
	}
	
	//********************************************
//	void print() {
//		System.out.println("pre print");
//		for(LinkedList<KeyValuePair<K,V>> bucket : buckets) {
//			System.out.println(bucket.toString());//null pointer exception 
//			if(bucket!=null) {
//				bucket.print();
//			}
//		}
//	}
	//*********************************************
	
}

//we cannot store Key and Value in linked list as data as this way we will destroy the structure of LL
//therefore create a class KeyValuePair and pass it object as reference to the linkedList data
class LinkedList<T>{
	Node<T> start;
	Node<T> tail;
	int size = 0;
	
	int getSize(){
		return size;
	}
	
	T getAtIndex(int index) {
		
		Node<T> temp = start;
		int i=0;
		
		while(i<index) { //i.e. reaching at index     //i<=index was giving null pointer exception
			
			i++;
			temp = temp.next;
		}
		
		return temp.data;  //this will return the keyValuePair at position "index"
		
	}
	
	T removeAt(int index) {
		Node<T> temp = start;
		if(start == null) {
			return null;
		}
		
		if(index == 0) {
			T data = temp.data;
			start = start.next;
			temp = null;
			size--;
			return data;
			
		}
		
		int i = 0;
		Node<T> prev = start;
		while(i<index) {
			prev = temp;
			temp = temp.next;
			i++;
		}
		Node<T> temp2 = temp;
		T data = temp.data;
		prev.next = temp.next;
		temp2 = null;
		size--;
		return data;		
		
	}
	
	void deleteNode(T data) {
		Node<T> temp = start;
		
		if(start == null) {
			throw new RuntimeException("LinkList is empty :(");
		}
		
		//data found on first node
		//if(start.data.equals(data)) {
		if(start.data == data) {
			if(start.next == null) {
				start = null;
				size--;
				return;
			}
			temp = start;
			start = start.next; //we should use temp node to assign it with start,
								//then shift the start
								//and delete the temp node by temp = null
								//this way memory is optimized
			size--;
			
			temp = null;
			return;
		}
		
		//data found on another node 

		Node<T> tempPrev = start;
		
		while(temp.next != null) {
			if(temp.data == data) {
				Node<T> temp2 = temp; //the purpose to temp2 is just to remove the address of temp
				tempPrev.next = temp.next;
				temp2 = null;
			}
			tempPrev = temp;
			temp = temp.next;
			size--;
		}
	}
	

	int search(T data) {
		
		int index = 0;
		Node<T> temp = start;
		
		while(temp != null) {
			
			
			if(temp.data.equals(data)) {  //we will have to override equals method as it will check for the same reference
										//instead of data. but sub class of object i.e. Integer, String, boolean will check
										//for the same data
				return index;
			}
			index++;
			temp = temp.next;
		}
		
		return -1;//-1 means we haven't found that node
		
	}
	
	// Node<T> node = new Node<>(data);
	//void addInLast(Node<T> node) { //if we are passing the node
	void addInLast(T data){ 
		Node<T> node = new Node<>(data);
		
		if(start == null) {
			tail = start = node;
		}else {
			tail.next = node;
			tail = node;
		}
		
		size++;
	}
	
	//*********************************************
	
	void print() {
				
		Node<T> temp = start;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		
	}
	
	//*********************************************
}

// K and V are Templates i.e. they can accept any data 
class KeyValuePair<K,V>{
	K key;
	V value;
	
	KeyValuePair(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if(this == object) { //if both the objects are at same address then return true :: it's a good practice
			return true;
		}
		
		
		//we will first have to check weather the object is of type KeyValuePair
		if(object instanceof KeyValuePair) {
			KeyValuePair keyValuePair = (KeyValuePair) object;
			if(this.key.equals(keyValuePair.key)) {  //here "this" is the keyvalue which we passed from LinkedList search method
				return true;					//therefore comparing the keys of both the objects
			}
		}
		
		return false;
	}
	
	//to get the meaningful data we have to override toString()
	@Override
	public String toString() {
		return "KeyValuePair [key=" + key + ", value=" + value + "]";
	}
	
}

//now we need Node Class to process it in linkedList
class Node<T>{
	T data;
	Node<T> next;
	
	//data will have reference to the object of class keyValuePair which will further have (Key and value)
	// data <= reference <= object <= class <= key value
	
	Node(T data){
		this.data = data;
	}
}




public class HashTableDemo {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> map = new HashMap<>();
		
		map.put("ram", 1233);
		map.put("ramesh", 34);
		map.put("rama", 1233);
		map.put("ravan", 1233);
		map.put("roll", 1233);
		map.put("rodies", 1233);
		map.put("rudy", 1233);
		map.put("rummies", 1233);
		map.put("shyam", 7488);
		
		map.print();
		
		System.out.println(map.get("abhi"));
		System.out.println(map.containKey("ramesh"));
		System.out.println(map.delete("roll"));
		System.out.println("****************after deletion********************");
		System.out.println();
		map.print();
		System.out.println("size of map is : " + map.size);
		//map.print();
		

	}

}
