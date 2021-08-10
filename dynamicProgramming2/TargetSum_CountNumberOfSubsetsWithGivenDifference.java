package dynamicProgramming2;
import java.util.*;
public class TargetSum_CountNumberOfSubsetsWithGivenDifference {
	public int findTargetSumWays(int[] nums, int diff) {
        int totSum = 0;
        for(int i=0; i<nums.length; i++) {
            totSum += nums[i];            
        }
        //the value of totSum + diff is always positive
        if(totSum < diff || (totSum + diff) % 2 != 0) {
            return 0;
        }
        
        int sumS1 = (diff + totSum) / 2;
        
        return countOfSubsetWithSumEqualToX(nums, nums.length, sumS1);
    }
    
    private int countOfSubsetWithSumEqualToX(int[] nums, int n, int tar) {
        int[][] dp = new int[n+1][tar+1];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                if(j == 0) {
                    dp[i][j] = 1;
                } else if(i == 0) {
                    dp[i][j] = 0;
                } else {
                    if(j < nums[i-1] || nums[i-1] == 0) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j];
                    }
                }
            }
        }
        int zeroCount = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                zeroCount++;
            }
        }
        
        return (int) Math.pow(2, zeroCount) * dp[n][tar];
    }
    
    
    //A more direct approach wrt te problem statement (leetcode solution)
    public class Solution {
        int count = 0;
        public int findTargetSumWays(int[] nums, int S) {
            int[][] memo = new int[nums.length][2001];
            for (int[] row: memo)
                Arrays.fill(row, Integer.MIN_VALUE);
            return calculate(nums, 0, 0, S, memo);
        }
        public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
            if (i == nums.length) {
                if (sum == S)
                    return 1;
                else
                    return 0;
            } else {
                if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                    return memo[i][sum + 1000];
                }
                int add = calculate(nums, i + 1, sum + nums[i], S, memo);
                int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
                memo[i][sum + 1000] = add + subtract;
                return memo[i][sum + 1000];
            }
        }
    }
}
