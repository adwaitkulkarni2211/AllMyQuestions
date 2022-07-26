package striverDP;

public class MinimumPathSum {
	class Solution {
	    private int solve_mem(int[][] grid, int row, int col, Integer[][] dp) {
	        if(row == 0 && col == 0) {
	            return grid[row][col];
	        }
	        
	        if(dp[row][col] != null) {
	            return dp[row][col];
	        }
	        
	        int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
	        
	        if(row == 0) {
	            right = solve_mem(grid, row, col - 1, dp);
	        } else if(col == 0) {
	            down = solve_mem(grid, row - 1, col, dp);
	        } else {
	            down = solve_mem(grid, row - 1, col, dp);
	            right = solve_mem(grid, row, col - 1, dp);
	        }
	        
	        return dp[row][col] = Math.min(down, right) + grid[row][col];
	    }
	    
	    private int solve_tab(int[][] grid, int m, int n) {
	        int[][] dp = new int[m][n];
	        
	        for(int row = 0; row < m; row++) {
	            for(int col = 0; col < n; col++) {
	                if(row == 0 && col == 0) {
	                    dp[row][col] = grid[row][col];
	                    continue;
	                }
	                
	                int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
	                if(row == 0) {
	                    right = dp[row][col - 1];
	                } else if(col == 0) {
	                    down = dp[row - 1][col];
	                } else {
	                    down = dp[row - 1][col];
	                    right = dp[row][col - 1];
	                }

	                dp[row][col] = Math.min(down, right) + grid[row][col];
	            }
	        }
	        
	        return dp[m - 1][n - 1];
	    }
	    
	    public int minPathSum(int[][] grid) {
	        int m = grid.length, n = grid[0].length;
	         Integer[][] dp = new Integer[m][n];
	         solve_mem(grid, m - 1, n - 1, dp);
	        
	        return solve_tab(grid, m, n);
	    }
	}
}
