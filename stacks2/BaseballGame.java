package stacks2;

import java.util.Stack;

public class BaseballGame {
	public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<ops.length; i++) {
            String op = ops[i];
            
            if(op.equals("D")) {
                int prev = st.peek();
                st.push(prev * 2);
            } else if(op.equals("C")) {
                st.pop();
            } else if(op.equals("+")) {
                int prev1 = st.pop();
                int prev2 = st.pop();
                
                st.push(prev2);
                st.push(prev1);
                st.push(prev1 + prev2);
            } else {
                st.push(Integer.parseInt(op));
            }
        }
        
        int sum = 0;
        
        while(!st.isEmpty()) {
            sum += st.pop();
        }
        
        return sum;
    }
}
