package dynamicProgramming2;
import java.util.*;
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
        if(s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        
        return solve(s1, s2, new HashMap<>());
    }
    
    private boolean solve(String s1, String s2, HashMap<String, Boolean> dp) {
        if(s1.equals(s2)) {
            return true;
        }
        if(s1.length() <= 1) {
            return false;
        }
        
        String id = s1 + "." + s2;
        if(dp.containsKey(id)) {
            return dp.get(id);
        }
        
        boolean flag = false;
        for(int i=1; i<s1.length(); i++) {
            int n = s1.length();
            //case 1: swapped
            boolean cond1 = solve(s1.substring(0,i), s2.substring(n-i), dp) 
                                    && solve(s1.substring(i), s2.substring(0, n-i), dp);
            //case 2: not swapped
            boolean cond2 = solve(s1.substring(0,i), s2.substring(0,i), dp) 
                                    && solve(s1.substring(i), s2.substring(i), dp);
            
            if(cond1 || cond2) {
                flag = true;
                break;
            }
        }
        dp.put(id, flag);
        return flag;
    }
}
