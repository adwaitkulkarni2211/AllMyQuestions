package dynamicProgramming2;
import java.util.*;
public class BooleanParenthesization {
	static int countWays(int n, String s) {
        int[][][] dp = new int[201][201][2];
        for(int[][] row1: dp) {
            for(int[] row2: row1) {
                Arrays.fill(row2, -1);
            }
        }
        return solve(s, 0, s.length() - 1, 1, dp);
    }
    
    static int solve(String str, int i, int j, int isTrue, int[][][] dp) {
        if(i > j) {
            return 0;
        }
        if(i == j) {
            if(isTrue == 1) {
                if(str.charAt(i) == 'T') return 1;
                else return 0;
            } else {
                if(str.charAt(i) == 'F') return 1;
                else return 0;
            }
        }
        
        if(dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }
        
        int ans = 0;
        for(int k=i+1; k<=j-1; k+=2) {
            int lt = solve(str, i, k-1, 1, dp);
            int lf = solve(str, i, k-1, 0, dp);
            int rt = solve(str, k+1, j, 1, dp);
            int rf = solve(str, k+1, j, 0, dp);
            
            char ch = str.charAt(k);
            if(ch == '^') {
                if(isTrue == 1)
                    ans += (lt * rf) + (lf * rt);
                else 
                    ans += (lt * rt) + (lf * rf);
            } else if(ch == '&') {
                if(isTrue == 1)
                    ans += lt * rt;
                else 
                    ans += (lf * rt) + (lt * rf) + (lf * rf);
            } else {
                if(isTrue == 1)
                    ans += (lf * rt) + (lt * rf) + (lt * rt);
                else 
                    ans += lf * rf;
            }
        }
        dp[i][j][isTrue] = ans % 1003;
        return ans % 1003;
    }
    
    //tabulation
    public static int solution(String str1, String str2) {
	    int n = str1.length();
		int[][] dpt = new int[n][n];
		int[][] dpf = new int[n][n];
		
		for(int g=0; g<n; g++) {
		    for(int i=0, j=g; j<n; j++, i++) {
		        if(g == 0) {
		            if(str1.charAt(i) == 'T') {
		                dpt[i][j] = 1;
		                dpf[i][j] = 0;
		            } else {
		                dpf[i][j] = 1;
		                dpt[i][j] = 0;
		            }
		        } else {
		            for(int k=i; k<j; k++) {
		                int ltc = dpt[i][k];
		                int rtc = dpt[k+1][j];
		                int lfc = dpf[i][k];
		                int rfc = dpf[k+1][j];
		                
		                int optr = str2.charAt(k);
		                
		                if(optr == '&') {
		                    dpt[i][j] += ltc * rtc;
		                    dpf[i][j] += (ltc * rfc) + (lfc * rtc) + (lfc * rfc);
		                } else if(optr == '|') {
		                    dpt[i][j] += (ltc * rfc) + (lfc * rtc) + (ltc * rtc);
		                    dpf[i][j] += lfc * rfc;
		                } else {
		                    dpt[i][j] += (ltc * rfc) + (lfc * rtc);
		                    dpf[i][j] += (lfc * rfc) + (ltc * rtc);
		                }
		            }
		        }
		    }
		}
		return dpt[0][n-1];
	}
}
