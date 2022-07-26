package striverDP;
import java.util.*;

public class HouseRobber {
	public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve_so(nums);
    }
    
	public int solve(int[] nums, int idx, int[] dp) {
        if(idx < 0) {
            return 0;
        }
        
        if(dp[idx] != -1) {
            return dp[idx];
        }
        
        int steal = solve(nums, idx - 2, dp) + nums[idx];
        int leave = solve(nums, idx - 1, dp);
        
        return dp[idx] = Math.max(steal, leave);
    }
    
    public int solve_tab(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        for(int i = 1; i < dp.length; i++) {
            int steal = nums[i];
            if(i > 1) steal += dp[i - 2];
            
            int leave = dp[i - 1];
            
            dp[i] = Math.max(steal, leave);
        }
        
        return dp[dp.length - 1];
    }
    
    private int solve_so(int[] nums) {
        int prev2 = 0, prev1 = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int steal = nums[i];
            if(i > 1) steal += prev2;
            
            int leave = prev1;
            
            int curr = Math.max(steal, leave);
            
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
