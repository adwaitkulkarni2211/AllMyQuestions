package striverDP;
import java.util.*;

public class Triangle {
	class Solution {
	    private int solve_mem(List<List<Integer>> triangle, int idx, int ht, Integer[][] dp) {
	    	if(ht == triangle.size() - 1) {
	            return triangle.get(ht).get(idx);
	        }
	        
	        if(dp[idx][ht] != null) {
	            return dp[idx][ht];
	        }
	        
	        int sum1 = solve_mem(triangle, idx, ht + 1, dp);
	        int sum2 = solve_mem(triangle, idx + 1,  ht + 1, dp);
	        
	        return dp[idx][ht] = Math.min(sum1, sum2) + triangle.get(ht).get(idx);
	    }
	    
	    private int solve_tab(List<List<Integer>> triangle) {
	        Integer[][] dp = new Integer[201][201];
	        int n = triangle.size();
	        
	        for(int i = n - 1; i >= 0 ; i--) {
	            for(int j = triangle.get(i).size() - 1; j >= 0; j--) {
	                if(i == n - 1) {
	                    dp[i][j] = triangle.get(i).get(j);
	                } else {
	                    int sum1 = dp[i + 1][j];
	                    int sum2 = dp[i + 1][j + 1];
	                    
	                    dp[i][j] = Math.min(sum1, sum2) + triangle.get(i).get(j);
	                }
	            }
	        }
	        
	        return dp[0][0];        
	    }
	    
	    public int minimumTotal(List<List<Integer>> triangle) {
	        Integer[][] dp =  new Integer[201][201];

	        solve_mem(triangle, 0, 0, dp);
	        
	        return solve_tab(triangle);
	    }
	}
}
