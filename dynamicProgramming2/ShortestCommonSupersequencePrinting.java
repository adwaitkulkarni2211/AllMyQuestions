package dynamicProgramming2;

public class ShortestCommonSupersequencePrinting {
	public String shortestCommonSupersequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
		char[] s2 = text2.toCharArray();
        int[][] lcs = solve(s1, s2, text1.length(), text2.length());
        
        String ans = "";
		int i = lcs.length - 1, j = lcs[0].length - 1;
		
		while(i > 0 && j > 0) {
			if(s1[i-1] == s2[j-1]) {
				ans = s1[i-1] + ans;
				i--;
				j--;
			} else {
				if(lcs[i-1][j] > lcs[i][j-1]) {
                    ans = s1[i-1] + ans;
					i--;
				} else {
                    ans = s2[j-1] + ans;
					j--;
				}
			}
		}
        //either i is 0 or j is 0. So we have to add the remaining string to ans
        while(i > 0) {
            ans = s1[i-1] + ans;
            i--;
        }
        while(j > 0) {
            ans = s2[j-1] + ans;
            j--;
        }
        
        return ans;
    }
    
    private static int[][] solve(char[] s1, char[] s2, int n, int m) {
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
        
        return dp;
    }
}
