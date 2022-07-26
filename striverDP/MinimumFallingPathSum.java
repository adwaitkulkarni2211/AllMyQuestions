package striverDP;

public class MinimumFallingPathSum {
	private int solve(int[][] matrix, int row, int col, Integer[][] dp) {
        if(col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1)
            return Integer.MAX_VALUE;
            
        if(row == matrix.length - 1) 
            return matrix[row][col];
        
        if(dp[row][col] != null)
            return dp[row][col];
        
        int leftDiag = solve(matrix, row + 1, col - 1, dp);
        int rightDiag = solve(matrix, row + 1, col + 1, dp);
        int down = solve(matrix, row + 1, col, dp);
        
        int min = Math.min(down, Math.min(leftDiag, rightDiag));
        
        return dp[row][col] = (min == Integer.MAX_VALUE) ? matrix[row][col] : min + matrix[row][col];
    }
    
    private int solve_tab(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int row = matrix.length - 1; row >= 0; row--) {
            for(int col = matrix[0].length - 1; col >= 0; col--) {
                if(row == matrix.length - 1) {
                    dp[row][col] = matrix[row][col];
                    continue;
                }
                
                boolean check = row == matrix.length - 1;
                
                int leftDiag = (check || col == 0) ? Integer.MAX_VALUE : dp[row + 1][col - 1];
                int rightDiag = (check || col == matrix[0].length - 1) ? Integer.MAX_VALUE : dp[row + 1][col + 1];
                int down = (check) ? Integer.MAX_VALUE : dp[row + 1][col];

                int min = Math.min(down, Math.min(leftDiag, rightDiag));

                dp[row][col] = (min == Integer.MAX_VALUE) ? matrix[row][col] : min + matrix[row][col];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < dp[0].length; j++) {
            min = Math.min(min, dp[0][j]);
        }
        
        return min;
    }
    
    public int minFallingPathSum(int[][] matrix) {
         Integer[][] dp = new Integer[matrix.length][matrix[0].length];
         int min = Integer.MAX_VALUE;
         for(int j = 0; j < matrix[0].length; j++) {
             min = Math.min(min, solve(matrix, 0, j, dp));
         }
        
        
        return solve_tab(matrix);
    }
}
