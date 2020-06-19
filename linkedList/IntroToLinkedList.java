package linkedList;

public class IntroToLinkedList<E> {
	static class Node<E> {
		public E data;
		public Node<E> next = null;
		public Node( E data) {
			this.data=data;
			next = null;
		}
	}
	Node<E> head;
	public void add( E data) {
		Node<E> toAdd = new Node<E> (data);
		if(isEmpty()) {
			head = toAdd;
			return;
		}	
		Node<E> temp = head;		
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = toAdd;		
	}
	boolean isEmpty() {
		return head==null;
	}
	 void print() {
		Node<E> temp = head;		
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	public E get( int index)
	{
		Node<E> temp = head;
		int i=0;
		if(temp==null) {
			System.out.println("no element present to remove");
		} else {
		while(temp.next!=null) {
			
			if(i == index) {
				break;
			}
			temp = temp.next;
			i++;
		}
		if(index>i) {
			System.out.println("Element does not exist!");
		}
		}
		return temp.data;		
	}
	public E getLast()
	{
		Node<E> temp = head;
		if(temp==null) {
			System.out.println("no element present to remove");
		} else {
		while(temp.next!=null) {
			temp = temp.next;
		}
		}
		return temp.data;		
	}
	void set(int index, E numberToInsert) {
		Node<E> temp = head;
		int i=0;
		while(temp.next!=null) {
			
			if(i == index) {
				break;
			}
			temp = temp.next;
			i++;
		}
		temp.data = numberToInsert;
	}
	public E removeLast() {
		Node<E> temp = head;
		if(temp==null) {
			System.out.println("no element present to remove");
		} else if(temp.next==null) {
			Node<E> toRemove = head;
			head=null;
			return toRemove.data;
		}
			while (temp.next.next != null) {
				temp = temp.next;
			}
			Node<E> toRemove = temp.next;
			temp.next = null;
			return toRemove.data;  
	}
}
