package dynamicProgramming2;

public class LongestIncreasingSubsequence {
	public void solve() {
		lis(new int[0], -1, 0, new int[2501][2501]);
	}
	//memoization
	private int lis(int[] nums, int prev, int idx, int[][] dp) {
        if(idx == nums.length) {
            return 0;
        }

        if(prev != -1 && dp[idx][prev] != 0) {
            return dp[idx][prev];
        }
        
        int inc = 0, exc = 0;
        
        if(prev == -1 || nums[idx] > nums[prev]) {
            inc = lis(nums, idx, idx + 1, dp) + 1;
            
        }
        exc = lis(nums, prev, idx + 1, dp);
        
        if(prev != -1) {
            dp[idx][prev] = Math.max(inc, exc);
        }
        return Math.max(inc, exc);
    }
	
	//tabulation (Time Complexity: o(n^2))
	public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];	//dp stores the length of LIS ending at the number on that index.
        
        dp[0] = 1;
        int ans = 1;
        for(int i=1; i<dp.length; i++) {
            int maxLis = Integer.MIN_VALUE;	//finding max length of all the LISs before i
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    maxLis = Math.max(maxLis, dp[j]);
                }
            }
            if(maxLis == Integer.MIN_VALUE) {	//if nums[i] < all the previous numbers, it can't be included to any IS
                dp[i] = 1;
            } else {
                dp[i] = maxLis + 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}
