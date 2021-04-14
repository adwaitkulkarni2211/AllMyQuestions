package stacks2;

public class DesignAStackToGetTheMiddleElement {

	public static class Node {
		Node next, prev;
		int data;
		
		Node(int data) {
			this.data = data;
			next = prev = null;
		}
	}
	
	public static class myStack {
		Node head, mid;
		int size;
		
		public myStack() {
			this.head = this. mid = null;
			size = 0;
		}
		
		
		public void push(int val) {
			if(head == null) {
				Node nn = new Node(val);
				head = nn;
				mid = nn;
				size = 1;
			} else {
				Node nn = new Node(val);
				head.next = nn;
				nn.prev = head;
				head = nn;
				size++;
				
				if(size % 2 == 0) {
					mid = mid.next;
				}
			}
		}
		
		public int pop() {
			if(size == 0) {
				System.out.println("Stack Underflow");
				return -1;
			}
			if(size == 1) {
				int ret = head.data;
				head = null;
				size--;
				return ret;
			}
			int ret = head.data;
			head = head.prev;
			head.next = null;
			size--;
			
			if(size % 2 == 1) {
				mid = mid.prev;
			}
			return ret;
		}
		
		public int findMin() {
			if(head == null) {
				System.out.println("Empty stack");
				return -1;
			}
			
			return mid.data;
		}
		
		public int deleteMin() {
			mid.prev.next  = mid.next;
			mid.next.prev = mid.prev;
			return mid.data;
		}
		
		public void display() {
			Node temp = head;
			System.out.print(temp.data);
			temp = temp.prev;
			while(temp != null) {
				System.out.print(" <- " + temp.data);
				temp = temp.prev;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		myStack ms = new myStack();
		for(int i=1; i<=8; i++) {
			ms.push(i);
			System.out.println("pushed " + i);
		}
		
		while(ms.size > 0) {
			ms.display();
			System.out.println("min is: " + ms.findMin());
			System.out.println("popped element is: " + ms.pop());
		}
		
	}

}
