package dynamicProgramming2;

public class MinimumNumberOfDeletionsAndInsertionsToConvertStringAToStringB {
	public int minOperations(String x, String y) {
	    char[] s1 = x.toCharArray();
        char[] s2 = y.toCharArray();
        int lcsLength = lcs(s1, s2, s1.length, s2.length);
        
        return s1.length + s2.length - (2 * lcsLength);
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
}
