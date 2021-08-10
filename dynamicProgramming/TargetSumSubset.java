package dynamicProgramming;
import java.util.*;
public class TargetSumSubset {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        sc.close();
        System.out.println("tab: " + solve(nums, n, tar));
        System.out.println("cleaner tab: " + solve2(nums, n, tar));
        System.out.println("mem: " + solve(nums, n, tar, new boolean[n+1][tar+1], 0));
    }
    //tabulation
    private static boolean solve(int[] nums, int n, int tar) {
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
        
        return dp[n][tar];
    }
    
    //cleaner tabulation
    private static boolean solve2(int[] nums, int n, int tar) {
    	boolean[][] dp = new boolean[n+1][tar+1];
    	
    	for(int i=0; i<dp.length; i++) {
    		for(int j=0; j<dp[i].length; j++) {
    			if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(j == 0) {
    				dp[i][j] = true;
    			} else if(i == 0) {
    				dp[i][j] = false;
    			} else {
    				if(j - nums[i-1] >= 0)
    				    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
    				else 
    				    dp[i][j] = dp[i-1][j];
    			}
    		}
    	}
    	
    	return dp[n][tar];
    }
    
    //memoization
    private static boolean solve(int[] nums, int n, int tar, boolean[][] dp, int idx) {
		if(idx == nums.length) {
			if(tar == 0) {
				return true;
			} else {
				return false;
			}
		}
		
		if(dp[idx][tar] != false) {
			return dp[idx][tar];
		}
		
		if(tar >= nums[idx]) {
			boolean in = solve(nums, n, tar - nums[idx], dp, idx + 1);
			boolean out = solve(nums, n, tar, dp, idx + 1);
			dp[idx][tar] = in || out;
			return dp[idx][tar];
		} else {
			boolean out = solve(nums, n, tar, dp, idx + 1);
			dp[idx][tar] = out;
			return dp[idx][tar];
		}
	}
}
