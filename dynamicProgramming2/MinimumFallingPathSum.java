package dynamicProgramming2;

public class MinimumFallingPathSum {
	public int minFallingPathSum(int[][] matrix) {
		solve(matrix, 0, 0, new int[0][0]);
        return solve_tab(matrix);
    }
    
    private int solve(int[][] matrix, int row, int col, int[][] dp) {
        if(row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1) {
            return Integer.MAX_VALUE;
        }
        
        if(dp[row][col] != 0) {
            return dp[row][col];
        }
        
        int leftDiag = solve(matrix, row + 1, col - 1, dp);
        int rightDiag = solve(matrix, row + 1, col + 1, dp);
        int down = solve(matrix, row + 1, col, dp);
        
        int min = Math.min(down, Math.min(leftDiag, rightDiag));
        
        return dp[row][col] = (min == Integer.MAX_VALUE) ? matrix[row][col] : min + matrix[row][col];
    }
    
    private int solve_tab(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int i = dp.length - 1; i >= 0; i--) {
            for(int j = dp[i].length - 1; j >= 0; j--) {
                if(i == dp.length - 1) {
                    dp[i][j] = matrix[i][j];
                } else if(j == 0) {
                    int rightDiag = dp[i + 1][j + 1];
                    int down = dp[i + 1][j];
                    
                    dp[i][j] = Math.min(rightDiag, down) + matrix[i][j];
                } else if(j == dp[i].length - 1) {
                    int leftDiag = dp[i + 1][j - 1];
                    int down = dp[i + 1][j];
                    
                    dp[i][j] = Math.min(leftDiag, down) + matrix[i][j];
                } else {
                    int leftDiag = dp[i + 1][j - 1];
                    int rightDiag = dp[i + 1][j + 1];
                    int down = dp[i + 1][j];

                    dp[i][j] = Math.min(down, Math.min(leftDiag, rightDiag)) + matrix[i][j];
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < dp[0].length; j++) {
            min = Math.min(min, dp[0][j]);
        }
        
        return min;
    }
}
