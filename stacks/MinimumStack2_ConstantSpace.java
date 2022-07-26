package stacks;
import java.util.*;
public class MinimumStack2_ConstantSpace {
	public static class MinStack {
		Stack<Integer> st = new Stack<>();
	    int min = Integer.MAX_VALUE;

	    /*returns min element from stack*/
	    int getMin() {
	        if(st.isEmpty() || min == Integer.MAX_VALUE)
	            return -1;
	        return min;
	    }
	    
	    public int top() {
	        if(st.isEmpty()) return -1;
	        
	        int top = st.peek();
	        
	        if(top < min) {
	            return min;
	        }
	        
	        return top;
	    }
	    
	    /*returns poped element from stack*/
	    int pop() {
	        if(st.isEmpty()) return -1;
	        
	        int top = st.pop();
	        
	        if(top < min) {
	            int orig = min;
	            min = 2 * min - top;
	            return orig;
	        }
	        
	        return top;
	    }

	    /*push element x into the stack*/
	    void push(int val) {
	        if(st.isEmpty()) {
	            st.push(val);
	            min = val;
	            return;
	        }
	        
	        if(val >= min)
	            st.push(val);
	        else {
	            st.push(2 * val - min);
	            min = val;
	        }
	    }	
    }

    public static void main(String[] args) throws Exception {
    }
}
