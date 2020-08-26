package queue;



public class MainClass {

	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<>();
		q.enqueue(12);
		q.enqueue(2);
		q.enqueue(123);
		q.enqueue(45);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(451);
		System.out.println(q.dequeue());
		
	}

}
