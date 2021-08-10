package dynamicProgramming2;

public class RodCutting {
	public int cutRod(int price[], int n) {
        int[] dp = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            for(int j=i; j<dp.length; j++) {
                dp[j] = Math.max(dp[j], dp[j-i] + price[i-1]);
            }
        }
        
        return dp[n];
    }
}
