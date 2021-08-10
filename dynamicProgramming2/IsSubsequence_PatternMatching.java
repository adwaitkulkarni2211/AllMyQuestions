package dynamicProgramming2;

public class IsSubsequence_PatternMatching {
	public boolean isSubsequence(String s, String t) {
        char[] s1 = s.toCharArray();
		char[] s2 = t.toCharArray();
        
        int lcsLength = lcs(s1, s2, s.length(), t.length());
        
        if(lcsLength == s.length()) {
            return true;
        } else {
            return false;
        }
    }
    
    private int lcs(char[] s1, char[] s2, int n, int m) {
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
