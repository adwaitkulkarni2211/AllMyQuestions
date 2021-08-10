package dynamicProgramming2;

public class CountOfSubsetsWithSumEqualToX {
	public static void main(String[] args) {
		int[] nums = {7,9,3,8,0,2,4,8,3,9};
		int tar = 0;
		Pair ans = perfectSum(nums, nums.length, tar);
		System.out.println("tab: " + ans.tab + " mem: " + ans.mem);
	}
	static class Pair {
		int tab, mem;
		Pair(int tab, int mem) {
			this.tab = tab;
			this.mem = mem;
		}
	}
	public static Pair perfectSum(int nums[], int n, int tar) {
	    int tab = solve(nums, nums.length, tar) % (int)(Math.pow(10, 9) + 7);
	    int mem = solve(nums, n, tar, new int[n+1][tar+1], 0);
	    
	    return new Pair(tab, mem);
	}
	
	private static int solve(int[] nums, int n, int tar) {
        int[][] dp = new int[n+1][tar+1];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                if(j == 0) {
                    dp[i][j] = 1;
                } else if(i == 0) {
                    dp[i][j] = 0;
                } else {
                	if(nums[i-1] == 0) {
                		dp[i][j] = dp[i-1][j];
                	} else if(j < nums[i-1]) {
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
	
	//memoization
	private static int solve(int[] nums, int n, int tar, int[][] dp, int idx) {
		if(idx == nums.length) {
			if(tar == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		
		if(dp[idx][tar] != 0) {
			return dp[idx][tar];
		}
		
		if(tar >= nums[idx]) {
			int in = solve(nums, n, tar - nums[idx], dp, idx + 1);
			int out = solve(nums, n, tar, dp, idx + 1);
			dp[idx][tar] = in + out;
			return dp[idx][tar];
		} else {
			int out = solve(nums, n, tar, dp, idx + 1);
			dp[idx][tar] = out;
			return dp[idx][tar];
		}
	}
}
