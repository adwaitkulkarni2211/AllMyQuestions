package dynamicProgramming2;
import java.util.*;
public class GenerateParanthesis {
	//memoization
	@SuppressWarnings("unchecked")
	List<String>[] dp = new List[9];
    public List<String> generateParenthesis(int n) {
        if(n == 0) {
            List<String> ret = new ArrayList<>();
            ret.add("");
            return ret;
        }
        if(n == 1) {
            List<String> ret = new ArrayList<>();
            ret.add("()");
            return ret;
        }
        
        if(dp[n] != null) {
            return dp[n];
        }
        
        int left = 0, right = n - 1;
        List<String> ans = new ArrayList<>();
        while(left <= n - 1) {
            List<String> in = generateParenthesis(left);
            List<String> out = generateParenthesis(right);
            
            for(String inStr: in) {
                for(String outStr: out) {
                    String totStr = "(" + inStr + ")" + outStr;
                    ans.add(totStr);
                }
            }
            
            left++;
            right--;
        }
        return dp[n] = ans;
    }
    //tabulation
    @SuppressWarnings("unchecked")
	public List<String> generateParenthesis2(int n) {
        List<String>[] dp = new List[9];
        
        dp[0] = new ArrayList<>();
        dp[0].add("");
        dp[1] = new ArrayList<>();
        dp[1].add("()");
        
        for(int i=2; i<=n; i++) {
            dp[i] = new ArrayList<>();
            int left = 0, right = i - 1;
            
            while(left <= i - 1) {
                for(String in: dp[left]) {
                    for(String out: dp[right]) {
                        String ans = "(" + in + ")" + out;
                        dp[i].add(ans);
                    }
                }                
                left++;
                right--;
            }
        }
        return dp[n];
    }
}
