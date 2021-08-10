package dynamicProgramming2;
import java.util.*;
public class RussianDollEnvelopes {
	class Pair implements Comparable<Pair> {
        int w, h;
        Pair(int w, int h) {
            this.w = w;
            this.h = h;
        }
        
        public int compareTo(Pair o) {
            return this.w - o.w;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Pair[] data = new Pair[n];
        for(int i=0; i<envelopes.length; i++) {
            data[i] = new Pair(envelopes[i][0], envelopes[i][1]);
        }
        
        Arrays.sort(data);
        
        int ans = lis(data);
        
        return ans;
    }
    
    private int lis(Pair[] data) {
        int[] dp = new int[data.length];
        dp[0] = 1;
        int ans = 1;
        
        for(int i=1; i<dp.length; i++) {
            int maxLis = Integer.MIN_VALUE;
            for(int j=0; j<i; j++) {
                if(data[i].h > data[j].h && data[i].w > data[j].w) {
                    maxLis = Math.max(maxLis, dp[j]);
                }
                if(maxLis == Integer.MIN_VALUE) {
                    dp[i] = 1;
                } else {
                    dp[i] = maxLis + 1;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
