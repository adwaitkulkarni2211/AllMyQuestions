package striverDP;

public class HouseRobber2 {
	class Solution {
	    public int rob(int[] nums) {
	        if(nums.length == 1) {
	            return nums[0];
	        }
	        
	        return Math.max(solve_so(nums, 0, nums.length - 2), solve_so(nums, 1, nums.length - 1));
	    }
	    
	    
	    private int solve_so(int[] nums, int start, int end) {
	        int prev2 = 0, prev1 = nums[start];
	        
	        for(int i = start + 1; i <= end; i++) {
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
}
