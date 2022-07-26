package striverDP;

public class UniquePath2 {
	private int solve_mem(int m, int n, Integer[][] dp, int[][] grid) {
        if(m < 0 || n < 0 || grid[m][n] == 1) return 0;
        if(m == 0 && n == 0) return 1;
        
        if(dp[m][n] != null) return dp[m][n];
        
        int down = solve_mem(m - 1, n, dp, grid);
        int right = solve_mem(m, n - 1, dp, grid);
        
        return dp[m][n] = down + right;
    }
    
    private int solve_tab(int M, int N, int[][] grid) {
        if(grid[M - 1][N - 1] == 1) return 0;
        
        int[][] dp = new int[M][N];
        
        for(int m = 0; m < M; m++) {
            for(int n = 0; n < N; n++) {
                if(grid[m][n] == 1) {
                    dp[m][n] = 0;
                    continue;
                }
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
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        solve_mem(m - 1, n - 1, new Integer[m][n], obstacleGrid);
        
        return solve_tab(m, n, obstacleGrid);
    }
}
