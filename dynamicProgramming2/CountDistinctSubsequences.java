package dynamicProgramming2;
import java.util.*;
public class CountDistinctSubsequences {
	long mod = 1000000007;
	public int distinctSubseqII(String str) {
        long[] dp = new long[str.length() + 1];
        dp[0] = 1;
        HashMap<Character, Integer> lo = new HashMap<>();
        
        for(int i=1; i<dp.length; i++) {
            dp[i] = (2 * dp[i-1]) % mod;
            
            
            char ch = str.charAt(i-1);
            if(lo.containsKey(ch)) {
                dp[i] = (dp[i] - dp[lo.get(ch) - 1] % mod + mod) % mod;
            }
            
            lo.put(ch, i);
        }
        
        return (int) ((dp[dp.length - 1] - 1) % mod);
    }
}
