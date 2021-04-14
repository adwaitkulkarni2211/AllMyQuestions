package stacks2;
import java.util.*;
public class InsertAtBottomOfStackInConstantSpace {
	
	public static void insertAtBottom(int val, Stack<Integer> st) {
		if(st.size() == 0) {
			st.push(val);
			return;
		}
		
		int popped = st.pop();
		insertAtBottom(val, st);
		st.push(popped);
	}
	
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		for(int i=1; i<=8; i++) {
			insertAtBottom(i, st);
			System.out.println(st);
		}
		
	}

}
