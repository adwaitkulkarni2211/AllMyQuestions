package striverDP;

public class CherryPickup2 {
	class Solution {
	    public int cherryPickup(int[][] grid) {
	        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
	        
	        return solve(grid, 0, 0, grid[0].length - 1, dp);
	    }
	    
	    private int solve(int[][] matrix, int row, int col1, int col2, int[][][] dp) {
	        if(col1 < 0 || col2 < 0 || row > matrix.length - 1 || col1 > matrix[0].length - 1 || col2 > matrix[0].length - 1) {
	            return Integer.MIN_VALUE;
	        }
	        
	        if(dp[row][col1][col2] != 0) {
	            return dp[row][col1][col2];
	        }
	        
	        int[] dir = {-1, 0, 1};
	        
	        int max = Integer.MIN_VALUE;
	        for(int i = 0; i < dir.length; i++) {
	            for(int j = 0; j < dir.length; j++) {
	                int newCol1 = col1 + dir[i];
	                int newCol2 = col2 + dir[j];
	                
	                max = Math.max(max, solve(matrix, row + 1, newCol1, newCol2, dp));
	            }
	        }
	        
	        int currSum;
	        if(col1 == col2) {
	            currSum = matrix[row][col1];
	        } else {
	            currSum = matrix[row][col1] + matrix[row][col2];
	        }
	        
	        return dp[row][col1][col2] = (max == Integer.MIN_VALUE) ? currSum : max + currSum;
	    }
	}
}
