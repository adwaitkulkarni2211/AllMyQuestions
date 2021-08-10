package dynamicProgramming2;
import java.util.*;
public class CoinChange_MinNumberOfCoins {
	public int coinChange(int[] coins, int tar) {
        int ans = solve(coins, coins.length, tar);
        
        if(ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }
    
    private int solve(int[] coins, int n, int tar) {
        int[] dp = new int[tar + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=0; i<coins.length; i++) {
            for(int j=coins[i]; j<dp.length; j++) {
                
                int amtLeft = dp[j - coins[i]];
                if(amtLeft != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], amtLeft + 1);    
                }
                
            }
            display(dp, coins[i]);
        }
        
        return dp[tar];
    }
    
    private void display(int[] dp, int n) {
        System.out.println("The array after processing " + n + " is:");
        for(int i=0; i<dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
