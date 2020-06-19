package stacks;

import linkedList.IntroToLinkedList;

public class StackWithLL<E> {
	private IntroToLinkedList<E> ll = new IntroToLinkedList<>();
	void push(E e) {
		ll.add(e);
	}
	E pop() {
		return ll.removeLast();
	}
	E peek() {
		return ll.getLast();
	}
}
