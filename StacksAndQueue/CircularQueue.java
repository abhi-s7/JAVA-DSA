package stackANDqueue;

class cQueue{
	private  int front, rear, capacity;
	private  int[] queue;
	
	cQueue(int c){
		front = rear = 0;
		capacity = c;
		queue = new int[capacity];
	}
	
	boolean isEmpty() {
		return rear == 0;
	}
	
	int getSize() {
		return rear;
	}
	
	void enqueue(int data) {
		if(rear == queue.length)
			throw new RuntimeException("Queue is full");
		
		int available_index = (front + rear) % queue.length;
		
		queue[available_index] = data;
		rear++;
	}
	
	int dequeue() {
		if(rear == 0)
			throw new RuntimeException("Queue is empty");
		
	int value = queue[front];
	queue[front] = 0;
	front = (front+1) % queue.length;
	rear--;   // rear is size therefore we decrement in dequeue
	
	return value;
	}
	
	int front() {
		if(rear == 0)
			throw new RuntimeException("Queue is empty");
		
		return queue[front];
	}
	
	void display() {
		for(int i = 0; i<queue.length; i++) {
			if(queue[i] != 0) {
				System.out.println("Element at: " + i + " is=" + queue[i]);
			}
		}
	}
}

public class CircularQueue {
	
	public static void main(String[] args) {
		cQueue queue = new cQueue(4);
		queue.enqueue(100);
		queue.enqueue(3000);
		queue.enqueue(9999);
		queue.enqueue(2000);
		// queue.enqueue(2000);//Queue is full
		queue.display();

		queue.dequeue();
		queue.dequeue();
		System.out.println("Now DeQueue Print");
		queue.enqueue(877);
//		queue.enqueue(641);
		queue.display();
	}
	
	

}
