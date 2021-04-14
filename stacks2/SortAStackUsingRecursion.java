package stacks2;
import java.util.Stack;
public class SortAStackUsingRecursion {
	
	public static void solve(Stack<Integer> st) {
	    if(st.size() == 1) {
	        return;
	    }
	    int popped = st.pop();
	    solve(st);
	    if(popped < st.peek()) {
	        Stack<Integer> temp = new Stack<>();
	        while(st.size() > 0 && popped < st.peek()) {
	            temp.push(st.pop());
	        }
	        st.push(popped);
	        while(temp.size() > 0) {
	            st.push(temp.pop());
	        }
	    } else {
	        st.push(popped);
	    }
	}
	
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		for(int i=8; i>=1; i--) {
			st.push(i);
		}
		System.out.println(st);
		solve(st);
		System.out.println(st);
	}

}
