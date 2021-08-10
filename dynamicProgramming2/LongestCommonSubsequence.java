package dynamicProgramming2;
import java.util.*;
public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        int mem = solve(s1, s2, n, m, dp);
        int tab = solve(s1, s2, n, m);
        System.out.println("tab: " + tab + " mem: " + mem);
        return tab;
    }
    
	//Memoization
    private int solve(char[] s1, char[] s2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) {
            return 0;
        }
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        
        //if common char found
        if(s1[n-1] == s2[m-1]) {
            dp[n][m] =  1 + solve(s1, s2, n-1, m-1, dp);
        } else {
            dp[n][m] =  Math.max(solve(s1, s2, n-1, m, dp), solve(s1, s2, n, m-1, dp));
        }
        
        return dp[n][m];
    }
    
    //tabulation
    private int solve(char[] s1, char[] s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if(s1[i-1] == s2[j-1]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        
        return dp[n][m];
    }
}
