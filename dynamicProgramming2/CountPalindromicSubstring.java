package dynamicProgramming2;

public class CountPalindromicSubstring {
	public int countSubstrings(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];
        int count = 0;
        
        for(int g=0; g<dp.length; g++) {
            for(int i=0, j=g; j<dp.length; i++, j++) {
                if(g == 0) {
                    dp[i][j] = true;
                    count++;
                } else if(g == 1) {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                        count++;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true) {
                        dp[i][j] = true;
                        count++;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return count;
    }
}
