package dynamicProgramming2;
import java.util.*;
public class EditDistance {
	public int minDistance(String word1, String word2) {
        StringBuilder s1 = new StringBuilder(word1);
        StringBuilder s2 = new StringBuilder(word2);
        
        dp = new int[501][501];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return solve(s1, s2, 0, 0);
    }
    
    int[][] dp;
    //memoization
    private int solve(StringBuilder word1, StringBuilder word2, int i, int j) {
        if(i == word1.length()) {
            if(j == word2.length()) {
                return 0;
            } else {
                return word2.length() - j;
            }
        }
        if(j == word2.length()) {
            if(i == word1.length()) {
                return 0;
            } else {
                return word1.length() - i;
            }
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        char c1 = word1.charAt(i);
        char c2 = word2.charAt(j);
        
        int min;
        if(c1 == c2) {
            min = solve(word1, word2, i + 1, j + 1);
        } else {
            //replace char            
            int rep = solve(word1, word2, i + 1, j + 1) + 1;
            
            //delete char            
            int del = solve(word1, word2, i + 1, j) + 1;
            
            //insert from word2 to word1            
            int ins = solve(word1, word2, i, j + 1) + 1;
            
            min = Math.min(del, Math.min(ins, rep));
        }
        
        return dp[i][j] = min;
    }
    
    //tabulation
    public int minDistance_tab(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[m+1][n+1];
        
        for(int i=dp.length - 1; i>=0; i--) {
            for(int j=dp[0].length - 1; j>=0; j--) {
                if(i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else if(i == dp.length - 1) {
                    dp[i][j] = dp[0].length - j - 1;
                } else if(j == dp[0].length - 1) {
                    dp[i][j] = dp.length - i - 1;
                } else {
                    char c2 = word1.charAt(j);
                    char c1 = word2.charAt(i);
                    
                    if(c1 == c2) {
                        dp[i][j] = dp[i+1][j+1];
                    } else {
                        int rep = dp[i+1][j+1];
                        int del = dp[i][j+1];
                        int ins = dp[i+1][j];
                        
                        dp[i][j] = Math.min(rep, Math.min(del, ins)) + 1;
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}
