package dynamicProgramming2;
import java.util.*;

public class DistinctTransformations {
    static int[][] dp;

	public static int solve(String s, String t, int si, int ti) {
		if(ti == t.length()) {
	        return 1;
	    } else if(si == s.length()) {
	        return 0;
	    }
	    
	    if(dp[si][ti] != -1) {
	        return dp[si][ti];
	    }
	    
		char c1 = s.charAt(si);
		char c2 = t.charAt(ti);
		
		int tot;
		if(c1 == c2) {
		    tot = solve(s, t, si + 1, ti + 1) + solve(s, t, si + 1, ti);
		} else {
		    tot = solve(s, t, si + 1, ti);
		}
		
		return dp[si][ti] = tot;
	}
	
	//tabulation
	public static int solve(String s, String t) {
	    int[][] dp = new int[t.length() + 1][s.length() + 1];
	    
	    for(int i=dp.length - 1; i>=0; i--) {
	        for(int j=dp[0].length - 1; j>=0; j--) {
	            if(i == dp.length - 1) {
	                dp[i][j] = 1;
	            } else if(j == dp[0].length - 1) {
	                dp[i][j] = 0;
	            } else {
	                char c1 = t.charAt(i);
	                char c2 = s.charAt(j);
	                if(c1 == c2) {
	                    dp[i][j] = dp[i+1][j+1] + dp[i][j+1];
    	            } else {
    	                dp[i][j] = dp[i][j+1];
    	            }
	            }
	        }
	    }
	    return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		scn.close();
		dp = new int[1001][1001];
		for(int[] row: dp) {
		    Arrays.fill(row, -1);
		}
		System.out.println(solve(s1, s2, 0, 0));
	}

}
