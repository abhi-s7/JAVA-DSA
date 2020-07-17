package stackANDqueue;

class Queue{
	private  int front, rear, capacity;
	private  int[] queue;
	
	Queue(int c){
		front = rear = 0;
		capacity = c;
		queue = new int[capacity];
	}
	
	public void enque(int data) {
		if(capacity == rear) {
			throw new RuntimeException("Queue is full");
		}
		
		queue[rear] = data;
		rear++;
	}
	
	public void dequeue() {
		if(front==rear) {
			throw new RuntimeException("Queue is empty");
		}
		
		for(int i = 0; i<rear-1; i++) {
			queue[i] = queue[i+1];
		}
		
		if(rear<capacity) {
			queue[rear] = 0;
		}
		
		rear--;
		
	}
	
	public void display() {
		if(front==rear) {
			throw new RuntimeException("Queue is empty");
		}
		
		for(int i = front; i<rear; i++) {
			System.out.println("Element at position: " + i + " is: " + queue[i]);
		}
		
	}
}


public class QueueWithArray01 {

	public static void main(String[] args) {

		Queue queue = new Queue(10);
		queue.enque(10);
		queue.enque(20);
		queue.enque(30);
		queue.enque(40);
		
		queue.display();
		
		System.out.println("*************************");
		
		queue.dequeue();
		
		queue.display();
	}
	
}
