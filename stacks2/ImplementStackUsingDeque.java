package stacks2;
import java.util.*;
public class ImplementStackUsingDeque {
	
	public static class myStack {
		ArrayDeque<Integer> ad = new ArrayDeque<>();
		
		void push(int val) {
			ad.addLast(val);
		}
		
		int pop() {
			return ad.removeLast();
		}
		
		int peek() {
			return ad.getLast();
		}
		
		void display() {
			System.out.println(ad);
		}
		
	}
	
	public static void main(String[] args) {
		myStack ms = new myStack();
		for(int i=1; i<=8; i++) {
			ms.push(i);
		}
		ms.display();
		ms.pop();
		ms.display();
		System.out.println(ms.peek());
	}

}
