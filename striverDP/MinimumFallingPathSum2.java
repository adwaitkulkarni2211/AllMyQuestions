package striverDP;

public class MinimumFallingPathSum2 {
	class Solution {
	    public int minFallingPathSum(int[][] grid) {
	        Integer[][] dp = new Integer[grid.length][grid[0].length];
	        
	        return solve(grid, 0, -1, dp);
	    }
	    
	    private int solve(int[][] grid, int row, int blockedCol, Integer[][] dp) {
	        if(row == grid.length)
	            return 0;
	        
	        if(blockedCol != - 1 && dp[row][blockedCol] != null)
	            return dp[row][blockedCol];
	        
	        int min = Integer.MAX_VALUE;
	        for(int j = 0; j < grid[row].length; j++) {
	            if(j != blockedCol) {
	                min = Math.min(min, solve(grid, row + 1, j, dp) + grid[row][j]);
	            }
	        }
	        
	        if(blockedCol != -1) {
	            dp[row][blockedCol] = min;
	        }
	        
	        return min;
	    }
	}
}
