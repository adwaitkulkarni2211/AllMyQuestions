package dynamicProgramming2;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) {
            return false;
        } else {
            return subsetSum(nums, nums.length, sum / 2);
        }
    }
    
    private boolean subsetSum(int[] nums, int n, int tar) {
        boolean dp[][] = new boolean[n+1][tar+1];
        
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
        
        return dp[n][tar];
    }

}
