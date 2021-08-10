package dynamicProgramming2;
import java.util.*;
public class CountDistictPalindromicSequences {
	public int countPalindromicSubsequences(String str) {
        long[][] dp = new long[str.length()][str.length()];
        int[] next = new int[str.length()];
        int[] prev = new int[str.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        
        //filling the prev and next arrays using a map
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
            if(map.containsKey(ch)) {
                prev[i] = map.get(ch);
            } else {
                prev[i] = -1;
            }
            map.put(ch, i);
        }
        
        map.clear();
        
        for(int i=str.length() - 1; i>=0; i--) {
            char ch = str.charAt(i);
            
            if(map.containsKey(ch)) {
                next[i] = map.get(ch);
            } else {
                next[i] = -1;
            }
            map.put(ch, i);
        }
        
        //solving using GAP strategy
        long mod = 1000000007;
        for(int g=0; g<dp.length; g++) {
            for(int i=0, j=g; j<dp.length; j++, i++) {
                if(g == 0) {
                    dp[i][j] = 1;
                } else if(g == 1) {
                    dp[i][j] = 2;
                } else {
                    if(str.charAt(i) == str.charAt(j)) {
                        int n = next[i];
                        int p = prev[j];
                        
                        if(n > p) {
                            dp[i][j] = (2 * dp[i+1][j-1] + 2) % mod;
                        } else if(n == p) {
                            dp[i][j] = (2 * dp[i+1][j-1] + 1) % mod;
                        } else if(n < p) {
                            dp[i][j] = (2 * dp[i+1][j-1] - dp[n + 1][p - 1] % mod + mod) % mod;
                        }
                    } else {
                        //prefix + suffix - mid
                        dp[i][j] = (dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] % mod + mod) % mod;
                    }
                }
            }
        }
        //System.out.println(dp[0][dp.length - 1]);
        return (int) dp[0][dp.length - 1];
    }
}
