package queues2;

public class CircularQueue {
	
	public static class circularQueue {
		int[] data;
		int front, rear;
		
		circularQueue() {
			data = new int[10];
			front = rear = -1;
		}
		
		void add(int val) {
			if(front == (rear + 1) % data.length) {
				System.out.println("Queue Overflow");
				return;
			}
			if(rear == -1) {
				data[0] = val;
				front = rear = 0;
				return;
			}
			rear = (rear + 1) % data.length;
			data[rear] = val;
		}
		
		int remove() {
			if(front == -1) {
				System.out.println("Queue Underflow");
				return -1;
			}
			
			if(front == rear) {
				int rem = data[front];
				front = rear = -1;
				return rem;
			}
			int rem = data[front];
			front = (front + 1) % data.length;
			return rem;
		}
		
		void display() {
			System.out.println();
			if(front > rear) {
				for(int i=front; i<data.length; i++) {
					System.out.print(data[i] + " ");
				}
				for(int i=0; i<=rear; i++) {
					System.out.print(data[i] + " ");
				}
			} else {
				for(int i=front; i<=rear; i++) {
					System.out.print(data[i] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		circularQueue cq = new circularQueue();
		for(int i=1; i<=8; i++) {
			cq.add(i);
		}
		cq.display();
		System.out.println(cq.remove());
		cq.remove();
		cq.remove();
		cq.remove();
		cq.remove();
		cq.remove();
		cq.display();
		cq.add(1);
		cq.display();
		cq.remove();
		cq.display();
	}

}
