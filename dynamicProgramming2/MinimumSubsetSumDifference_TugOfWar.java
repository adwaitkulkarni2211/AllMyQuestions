package dynamicProgramming2;
import java.util.*;
public class MinimumSubsetSumDifference_TugOfWar {
	public int minDifference(int nums[], int n) {
	    int sum = 0;
	    for(int i=0; i<nums.length; i++) {
	        sum += nums[i];
	    }
	    //using tss, we'll find sums of all the subsets by passing target as the total sum.
	    boolean[][] tss = targetSumSubset(nums, n, sum);
	    
	    HashSet<Integer> subsetSums = new HashSet<>();
	    
	    //The last row of the tss array will have stored true for all the possible values for sums of subsets
	    //Add them to a hashset for O(1) searching in the next loop
	    for(int i=0; i<tss[0].length; i++) {
	        if(tss[tss.length - 1][i] == true) {
	            subsetSums.add(i);
	        }
	    }
	    //Find the min value in the first half of the array using the formula (Range or sum) - 2 * S1 = min
	    int min = Integer.MAX_VALUE;
	    for(int i=0; i<=sum/2; i++) {
	        if(subsetSums.contains(i)) {
	            int diff = sum - (2 * i);
                min = Math.min(min, diff);
	        }
	    }
	    
	    return min;
	} 
	
	private static boolean[][] targetSumSubset(int[] nums, int n, int tar) {
        boolean[][] dp = new boolean[n+1][tar+1];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    //if the runs have already been scored, batsman doesn't bat
                    if(dp[i-1][j] == true) {
                        dp[i][j] = true;
                    }
                    //if the runs have not been scored and the batsman chooses to bat
                    else if(j-nums[i-1] >= 0 && dp[i-1][j-nums[i-1]] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        return dp;
    }
}
