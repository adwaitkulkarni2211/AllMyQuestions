package dynamicProgramming2;
import java.util.*;
public class EggDroppingProblem {
	public int superEggDrop(int e, int f) {
        int[][] dp = new int[101][10001];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return solve(e, f, dp);
    }
    
    private int solve(int e, int f, int[][] dp) {
        if(f == 0 || f == 1 || e == 1) {
            return f;
        }
        if(dp[e][f] != -1) {
            return dp[e][f];
        }
        
        int min = Integer.MAX_VALUE;
        
        int left = 1, right = f;
        
        while(left <= right) {
            int k = (left + right) / 2;
            
            int leftRes = solve(e-1, k-1, dp);
            int rightRes = solve(e, f-k, dp);
            
            int temp = 1 + Math.max(leftRes, rightRes);
            
            min = Math.min(min, temp);
            
            if(leftRes < rightRes) {
                left = k + 1;
            } else {
                right = k - 1;
            }
        }
        dp[e][f] = min;
        return min;
    }
    //tabulation (TLE on leetcode):
    public int superEggDrop_tab(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];
        
        for(int i=1; i<=e; i++) {
            for(int j=1; j<=f; j++) {
                if(i == 1) {
                    dp[i][j] = j;
                } else if(j == 1) {
                    dp[i][j] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    for(int cj = j - 1, pj = 0; cj >=0 && pj < j; cj--, pj++) {
                        int val1 = dp[i-1][pj];
                        int val2 = dp[i][cj];
                        
                        int val = Math.max(val1, val2);
                        
                        min = Math.min(min, val);
                    }
                    
                    dp[i][j] = min + 1;
                }
            }
        }
        
        return dp[e][f];
    }
}
