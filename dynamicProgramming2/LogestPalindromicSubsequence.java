package dynamicProgramming2;

public class LogestPalindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
        String rev = "";
        for(int i=s.length()-1; i>=0; i--) {
            rev += s.charAt(i);
        }
        
        char[] s1 = s.toCharArray();
        char[] s2 = rev.toCharArray();
        
        return lcs(s1, s2, s1.length, s2.length);
    }
    
    private static int lcs(char[] s1, char[] s2, int n, int m) {
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
    
    @SuppressWarnings("unused")
	private int lps(String str, int i, int j, int[][] dp) {
        if(i >= j) {
            return (i == j) ? 1 : 0;
        }
        
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        
        if(str.charAt(i) == str.charAt(j)) {
            return dp[i][j] = lps(str, i + 1, j - 1, dp) + 2;
        } else {
            return dp[i][j] = Math.max(lps(str, i + 1, j, dp), lps(str, i, j - 1, dp));
        }
    }
    
    @SuppressWarnings("unused")
	private int lps_tab(String str, int I, int J, int[][] dp) {
        for(int g = 0; g < str.length(); g++) {
            for(int i = 0, j = g; j < str.length(); i++, j++) {
                if(i >= j) {
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }

                if(str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[I][J];
    }
}
