package dynamicProgramming2;

public class WildcardMatching {
	public boolean isMatch(String str, String pat) {
        boolean[][] dp = new boolean[pat.length() + 1][str.length() + 1];
        
        for(int i = dp.length - 1; i >= 0; i--) {
            for(int j = dp[i].length - 1; j >= 0; j--) {
                if(i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = true;
                } else if(i == dp.length - 1) {
                    dp[i][j] = false;
                } else if(j == dp[0].length - 1) {
                    if(pat.charAt(i) == '*') {
                        dp[i][j] = dp[i+1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if(pat.charAt(i) == '?') {
                        dp[i][j] = dp[i+1][j+1];
                    } else if(pat.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i+1][j+1];
                    } else if(pat.charAt(i) == '*') {
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}
