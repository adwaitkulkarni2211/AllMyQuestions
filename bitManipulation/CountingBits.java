package bitManipulation;

public class CountingBits {
	public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        
        for(int i=1; i<dp.length; i++) {
            int x = (i & (i - 1));
            dp[i] = dp[x] + 1;
        }
        
        return dp;
    }
}
