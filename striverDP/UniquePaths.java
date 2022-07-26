package striverDP;

public class UniquePaths {
	public int solve_mem(int m, int n, Integer[][] dp) {
        if(m < 0 || n < 0) return 0;
        if(m == 0 && n == 0) return 1;
        
        if(dp[m][n] != null) return dp[m][n];
        
        int down = solve_mem(m - 1, n, dp);
        int right = solve_mem(m, n - 1, dp);
        
        return dp[m][n] = down + right;
    }
    
	public int solve_tab(int M, int N) {
        int[][] dp = new int[M][N];
        
        for(int m = 0; m < M; m++) {
            for(int n = 0; n < N; n++) {
                if(m == 0 && n == 0) {
                    dp[m][n] = 1;
                    continue;
                }
                
                int down = (m == 0) ? 0 : dp[m - 1][n];
                int right = (n == 0) ? 0 : dp[m][n - 1];

                dp[m][n] = down + right;
            }
        }
        
        return dp[M - 1][N - 1];
    }
    
    public int uniquePaths(int m, int n) {
        // Integer[][] dp = new Integer[m][n];
        // return solve_mem(m - 1, n - 1, dp);
        
        return solve_tab(m, n);
    }
}
