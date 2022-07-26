package striverDP;

public class MaximumSumNonAdjacentElement {
	public int solve_mem(int[] nums, int idx, Integer[] dp) {
        if(idx == 0) return nums[idx];
        if(idx < 0) return 0;
        
        if(dp[idx] != null) return dp[idx];
        //include
        int inc = solve_mem(nums, idx - 2, dp) + nums[idx];
        //exclude
        int exc = solve_mem(nums, idx - 1, dp);
        
        return dp[idx] = Math.max(inc, exc);
    }
    
    public int solve_tab(int[] nums, int n) {
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        
        for(int idx = 1; idx < n; idx++) {
            //include
            int inc = (idx >= 2) ? dp[idx - 2] + nums[idx] : nums[idx];
            //exclude
            int exc = dp[idx - 1];
            
            dp[idx] = Math.max(inc, exc);
        }
        
        return dp[n - 1];
        
    }
    
    private int solve_so(int nums[], int n) {
        int prev1 = nums[0], prev2 = 0, curr = 0;
        
        for(int idx = 1; idx < n; idx++) {
            //include
            int inc = prev2 + nums[idx];
            //exclude
            int exc = prev1;
            
            curr = Math.max(inc, exc);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
    int findMaxSum(int nums[], int n) {
        // return solve_mem(nums, n - 1, new Integer[n]);
        
        // return solve_tab(nums, n);
        
        return solve_so(nums, n);
    }
}
