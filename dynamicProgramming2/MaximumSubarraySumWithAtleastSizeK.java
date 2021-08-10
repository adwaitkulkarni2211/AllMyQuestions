package dynamicProgramming2;

public class MaximumSubarraySumWithAtleastSizeK {
	public long maxSumWithK(long nums[], long n, int k) {
        long[] dp = kadanes(nums);
        long ans = Long.MIN_VALUE;
        
        long exactK = 0;
        for(int i=0; i<k; i++) {
            exactK = exactK + nums[i];
        }
        
        ans = Math.max(ans, exactK);
        
        for(int i=k; i<nums.length; i++) {
            exactK = exactK - nums[i - k] + nums[i];
            
            ans = Math.max(ans, exactK);
            
            long moreThanK = dp[i - k] + exactK;
            
            ans = Math.max(ans, moreThanK);
        }
        
        return ans;
    }
    
    private long[] kadanes(long nums[]) {
        long csum = nums[0];
        long[] dp = new long[nums.length];
        dp[0] = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            if(csum > 0) {
                csum += nums[i];
            } else {
                csum = nums[i];
            }
            dp[i] = csum;
        }
        return dp;
    }
}
