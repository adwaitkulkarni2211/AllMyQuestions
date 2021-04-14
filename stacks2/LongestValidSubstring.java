package stacks2;
import java.util.Stack;
public class LongestValidSubstring {
	//leetcode 32
	public static void main(String[] args) {
		String str = "()(()))))";
		findMaxLen(str);

	}
	
	public static int findMaxLen(String str) {
        Stack<Integer> st = new Stack<>();
        int count = 0;
        st.push(-1);
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch == '(') {
                st.push(i);
            } else {
                if(st.size() > 0) {
                    st.pop();
                }
                if(st.size() > 0) {
                    count = Math.max(count, i - st.peek());
                } else {
                    st.push(i);
                }
                System.out.println("count: " + count);
            }
        }
        return count;
	}

}
