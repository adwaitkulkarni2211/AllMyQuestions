package stacks2;
import java.util.*;

public class RemoveAllAdjacentDuplicatesInString2 {
	class Solution {
	    class Pair {
	        char ch;
	        int count;
	        Pair(char ch, int count) {
	            this.ch = ch;
	            this.count = count;
	        }
	    }
	    public String removeDuplicates(String s, int k) {
	        Stack<Pair> st = new Stack<>();
	        st.push(new Pair(s.charAt(s.length() - 1), 1));
	        
	        for(int i = s.length() - 2; i >= 0; i--) {
	            char ch = s.charAt(i);
	            
	            if(st.isEmpty()) {
	                st.push(new Pair(ch, 1));
	                continue;
	            }
	            
	            Pair top = st.peek();
	            
	            if(top.ch == ch && top.count < k - 1) {
	                st.push(new Pair(ch, top.count + 1));
	            } else if(top.ch == ch && top.count == k - 1) {
	                while(!st.isEmpty() && st.peek().ch == ch) {
	                    st.pop();
	                }
	            } else {
	                st.push(new Pair(ch, 1));
	            }
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        
	        while(!st.isEmpty()) {
	            sb.append(st.pop().ch);
	        }
	        
	        return sb.toString();
	    }
	}
}
