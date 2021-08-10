package dynamicProgramming2;

public class MinimumDeletionsToMakeStringPalindrome {
	static int minimumNumberOfDeletions(String s) {
        int lps = longestPalindromeSubseq(s);
        return s.length() - lps;
    }
    
    static int longestPalindromeSubseq(String s) {
        String rev = "";
        for(int i=s.length()-1; i>=0; i--) {
            rev += s.charAt(i);
        }
        
        char[] s1 = s.toCharArray();
        char[] s2 = rev.toCharArray();
        
        return lcs(s1, s2, s1.length, s2.length);
    }
    
    static int lcs(char[] s1, char[] s2, int n, int m) {
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
