package dynamicProgramming2;

public class NumberOfDistinctBSTs {
	int numTrees(int n) {
		//no. BSTs = Nth Catalan Number
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<dp.length; i++) {
            for(int j=0; j<i; j++) {
                dp[i] = ((dp[i] % 1000000007) + (dp[j] * dp[i - j - 1]) % 1000000007) % 1000000007;
            }
        }
        
        return (int) dp[n];
    }
}
