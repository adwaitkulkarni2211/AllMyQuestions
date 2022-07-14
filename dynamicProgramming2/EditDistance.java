package dynamicProgramming2;
import java.util.*;
public class EditDistance {
	public int minDistance(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        
        mem(s1, s2, n, m, dp);
        return tab(s1, s2, n, m, dp);
    }
    
    private int mem(String s1, String s2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) {
            return (n != 0) ? n : m;
        }
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m] = mem(s1, s2, n - 1, m - 1, dp);
        } else {
            int replace = mem(s1, s2, n - 1, m - 1, dp);
            int delete = mem(s1, s2, n - 1, m, dp);
            int insert = mem(s1, s2, n, m - 1, dp);

            return dp[n][m] = Math.min(replace, Math.min(delete, insert)) + 1;
        } 
    }
    
    private int tab(String s1, String s2, int N, int M, int[][] dp) {
        for(int n = 0; n <= N; n++) {
            for(int m = 0; m <= M; m++) {
                if(n == 0 || m == 0) {
                    dp[n][m] = (n != 0) ? n : m;
                    continue;
                }

                if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
                    dp[n][m] = dp[n - 1][m - 1];
                } else {
                    int replace = dp[n - 1][m - 1];
                    int delete = dp[n - 1][m];
                    int insert = dp[n][m - 1];

                    dp[n][m] = Math.min(replace, Math.min(delete, insert)) + 1;
                } 
            }
        }
        
        return dp[N][M];
    }
}
