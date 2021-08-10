package dynamicProgramming2;
import java.util.*;
public class MatrixChainMultiplication {
	int matrixMultiplication(int n, int a[]) {
        int[][] dp = new int[101][101];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return solve(a, 1, n-1, dp);
    }
    
    int solve(int a[], int i, int j, int[][] dp) {
        if(i >= j) {
            return 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int k=i; k<=j-1; k++) {
            int temp = solve(a, i, k, dp) + solve(a, k+1, j, dp) + (a[i-1] * a[k] * a[j]);
            min = Math.min(min, temp);
        }
        
        dp[i][j] = min;
        return min;
    }
    
    //tabulation
    public static int mcm(int[] arr){
		int[][] dp = new int[arr.length - 1][arr.length - 1];
		
		for(int g=0; g<dp.length; g++) {
		    for(int i=0, j=g; j<dp.length; i++, j++) {
		        if(g == 0) {
		            dp[i][j] = 0;
		        } else if(g == 1) {
		            dp[i][j] = arr[i] * arr[j] * arr[j + 1];
		        } else {
		            int min = Integer.MAX_VALUE;
		            for(int k=i; k<j; k++) {
		                int left = dp[i][k];
		                int right = dp[k+1][j];
		                int m = arr[i] * arr[k+1] * arr[j+1];
		                
		                int cost = left + right + m;
		                
		                min = Math.min(min, cost);
		            }
		            dp[i][j] = min;
		        }
		    }
		}
		
		return dp[0][dp.length - 1];
	}
}
