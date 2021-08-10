package dynamicProgramming2;
import java.util.*;
public class PerfectSquares_MinSqauresThatSumUpToN {
	public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        
        for(int i=2; i<dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=1; j * j<=i; j++) {
                int sq = j * j;
                if(i - sq >= 0)
                    min = Math.min(min, dp[i - sq]);
            }
            dp[i] = min + 1;
        }
        
        return dp[n];
    }
	
	//Coin Change Approach:
	public int coinChange1(int n) {
		int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=1; i*i<=n; i++) {
            int isq = i*i;
            for(int j=isq; j<dp.length; j++) {
                int amtLeft = dp[j - isq];
                if(amtLeft != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], amtLeft + 1);
                }
            }
        }
        return dp[n];
	}
}
