package stackANDqueue;

class Queue2 {
	private int[] array;
	private int rear, front;
	private int default_capacity = 10;
	private int size;

	Queue2() {
		array = new int[default_capacity];
		front = rear = -1;
		size = 0;
	}

	Queue2(int capacity) {
		array = new int[capacity];
		front = rear = -1;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	int getFrontValue() {
		if(size==0) {
			throw new RuntimeException("Queue is Empty , Nothing on Front");
		}
		return array[front];
	}
	
	public void enqueue(int data) {
		if (size == array.length) {
			throw new RuntimeException("Queue is full");
		}

		if (size == 0)
			front = 0;

		size++;
		rear++;
		if (rear == array.length) {
			rear = 0;
		}

		array[rear] = data;
	}

	int dequeue() {
		if (size == 0)
			throw new RuntimeException("Queue is empty");
		/*
		 * array[front] = 0; front++; size--;
		 */

		int temp = array[front];
		front++;
		if (front == array.length) {
			front = 0;
		}

		size--;
		if (size == 0) {
			front = rear = -1;
		}

		return temp;
	}

	void print() {
		while (!isEmpty()) {
			System.out.println(dequeue());
		}
	}
	/*	 * void print() { if(size==0) throw new RuntimeException("Queue is empty");
	 * 
	 * for(int temp:array ) { System.out.println(temp); }
	 * 
	 * }
	 */
}

public class QueueWithArray02 {

	public static void main(String[] args) {
		Queue2 queue = new Queue2(4);
		queue.enqueue(100);
		queue.enqueue(3000);
		queue.enqueue(9999);
		queue.enqueue(2000);
		// queue.enqueue(2000);//Queue is full
		// queue.print();

		queue.dequeue();
		queue.dequeue();
		System.out.println("Now DeQueue Print");
		queue.enqueue(877);
		queue.print();
	}

}
