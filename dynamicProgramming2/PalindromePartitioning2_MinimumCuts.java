package dynamicProgramming2;

public class PalindromePartitioning2_MinimumCuts {
	static int palindromicPartition(String s) {
        int[][] dp = new int[2001][2001];
        
        return solve(s, 0, s.length() - 1, dp);
    }
    //TLE on leetcode
    static int solve(String str, int i, int j, int[][] dp) {
        if(i >= j) {
            return 0;
        }
        
        if(isPalindrome(str, i, j)) {
            return 0;
        }
        
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
            
        int min = Integer.MAX_VALUE;
        
        for(int k=i; k<=j-1; k++) {
            int temp = solve(str, i, k, dp) + solve(str, k+1, j, dp) + 1;
            
            min = Math.min(min, temp);
        }
        
        dp[i][j] = min;
        return min;
    }
    
    static boolean isPalindrome(String str, int i, int j) {
        while(i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    
    //tabulation O(n^2):
    public int minCut(String str) {
        boolean[][] dp1 = new boolean[str.length()][str.length()];
        
        for(int g=0; g<str.length(); g++) {
            for(int i=0, j=g; j<str.length(); j++, i++) {
                if(g == 0) {
                    dp1[i][j] = true;
                } else if(g == 1) {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp1[i][j] = true;
                    }
                } else {
                    if(str.charAt(i) == str.charAt(j) && dp1[i+1][j-1] == true) {
                        dp1[i][j] = true;
                    }
                }
            }
        }
        
        int[] dp2 = new int[str.length()];
        dp2[0] = 0;
        
        for(int j=1; j<dp2.length; j++) {
            if(dp1[0][j] == true) {
                dp2[j] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for(int i=j; i>=1; i--) {
                    if(dp1[i][j] == true) {
                        min = Math.min(min, dp2[i-1]);
                    }
                    dp2[j] = min + 1;
                }    
            }
        }
        
        return dp2[str.length() - 1];
    }
    
    //tabulation O(n^3):
    public int minCut1(String str) {
        boolean[][] dp1 = new boolean[str.length()][str.length()];
        
        for(int g=0; g<str.length(); g++) {
            for(int i=0, j=g; j<str.length(); j++, i++) {
                if(g == 0) {
                    dp1[i][j] = true;
                } else if(g == 1) {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp1[i][j] = true;
                    }
                } else {
                    if(str.charAt(i) == str.charAt(j) && dp1[i+1][j-1] == true) {
                        dp1[i][j] = true;
                    }
                }
            }
        }
        
        int[][] dp2 = new int[str.length()][str.length()];
        
        for(int g=0; g<str.length(); g++) {
            for(int i=0, j=g; j<str.length(); j++, i++) {
                if(g == 0) {
                    dp2[i][j] = 0;
                } else if(g == 1) {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp2[i][j] = 0;
                    } else {
                        dp2[i][j] = 1;
                    }
                } else {
                    if(dp1[i][j] == true) {
                        dp2[i][j] = 0;
                    } else {
                        int min = Integer.MAX_VALUE;
                        for(int k=i; k<=j-1; k++) {
                            int left = dp2[i][k];
                            int right = dp2[k+1][j];
                            
                            min = Math.min(min, left + right);
                        }
                        dp2[i][j] = min + 1;
                    }
                }
            }
        }
        return dp2[0][str.length() - 1];
    }
}
