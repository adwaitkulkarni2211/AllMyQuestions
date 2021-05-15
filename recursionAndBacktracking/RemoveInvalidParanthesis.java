package recursionAndBacktracking;
import java.util.*;
public class RemoveInvalidParanthesis {
	HashSet<String> set;
    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        int min = minRemove(s);
        solve(min, s, set);
        ArrayList<String> ans = new ArrayList<>();
        for(String str: set) {
            ans.add(str);
        }
        if(ans.size() == 0) {
            ans.add("");
        }
        return ans;
    }
    
    public void solve(int minRems, String str, HashSet<String> set) {        
        if(minRems == 0) {
            int minRemsNow = minRemove(str);
            if(minRemsNow == 0) {
                set.add(str);
            }
            return;
        }
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == ')') {
                String afterRemoval = str.substring(0, i) + str.substring(i+1);
                solve(minRems - 1, afterRemoval, set);
            }            
        }
    }
    
    public int minRemove(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(ch);
            } else if(ch == ')' ) {
                if(st.size() == 0) {
                    st.push(ch);
                } else if(st.peek() == '(' ) {
                    st.pop();
                } else if (st.peek() == ')' ) {
                    st.push(ch);
                }
            }
        }
        return st.size();
    }
}
