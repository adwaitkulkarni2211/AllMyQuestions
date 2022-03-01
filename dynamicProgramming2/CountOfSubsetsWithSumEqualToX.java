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
        
        //this needs to be done because in the 1st column of the dp array (dp[i][0]),
        //we are storing 1 in all cells as there is only 1 subset that satisfies the current
        //target, 0, which is the empty subset (phi). However, when we have a 0 as an element
        //in the nums array, this changes. There will be 2 subsets that add up to 0 (phi, {0}).
        //So the 1st column will no longer store all 1s and to make this happen we'll have to make
        //drastic changes to the code above.
        
        //if a 0 is added to a nums array, the number of subsets will be doubled. if two 0s
        //are added it will be quadrupled and so on. Again, because each 0 will have two options,
        //getting included or not getting included. And the special thing about the 0 is that
        //including it will not affect the sum of that subset. 
        //Check the dp table drawn in the notebook after water connection problem and before linkedList
        
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
