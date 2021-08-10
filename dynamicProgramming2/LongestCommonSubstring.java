package dynamicProgramming2;

public class LongestCommonSubstring {
	int longestCommonSubstr(String text1, String text2, int n, int m){
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        
        int ans = solve(s1, s2, n, m);
        if(ans == Integer.MIN_VALUE) {
            return 0;
        } else {
            return ans;
        }
    }
    
    private int solve(char[] s1, char[] s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if(s1[i-1] == s2[j-1]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                        max = Math.max(max, dp[i][j]);
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        
        return max;
    }
}
