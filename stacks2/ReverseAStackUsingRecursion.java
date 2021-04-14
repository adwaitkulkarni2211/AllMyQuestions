package stacks2;
import java.util.*;
public class ReverseAStackUsingRecursion {
	
	public static void insertAtBottom(int val, Stack<Integer> st) {
		if(st.size() == 0) {
			st.push(val);
			return;
		}
		
		int popped = st.pop();
		insertAtBottom(val, st);
		st.push(popped);
	}
	
	public static void reverse(Stack<Integer> st) {
		if(st.size() == 1) {
			insertAtBottom(st.pop(), st);
			return;
		}
		
		int popped = st.pop();
		reverse(st);
		insertAtBottom(popped, st);
	}
	
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		for(int i=1; i<=8; i++) {
			st.push(i);
		}
		System.out.println(st);
		reverse(st);
		System.out.println(st);
	}

}
