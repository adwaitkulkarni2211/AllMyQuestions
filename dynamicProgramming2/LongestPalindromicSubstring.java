package dynamicProgramming2;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];
        int maxLen = Integer.MIN_VALUE;
        String ans = "";
        
        for(int g=0; g<dp.length; g++) {
            for(int i=0, j=g; j<dp.length; i++, j++) {
                if(g == 0) {
                    dp[i][j] = true;
                } else if(g == 1) {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                String temp = str.substring(i, j + 1);
                if(dp[i][j] == true) {
                    if(temp.length() > maxLen) {
                        ans = temp;
                        maxLen = temp.length();
                        //System.out.println(ans);
                    }
                }
            }
        }
        return ans;
    }
}
