package dynamicProgramming2;
import java.util.*;
public class LongestBitonicSubsequence {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        
        int[] sum = new int[n];     //to store the sums lis and lds
        //LIS ending at each point:
        int[] dp = new int[n];
        dp[0] = 1;
        sum[0] = 1;
        for(int i=1; i<dp.length; i++) {
            int maxLis = Integer.MIN_VALUE;
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    maxLis = Math.max(maxLis, dp[j]);
                }
            }
            if(maxLis == Integer.MIN_VALUE) {
                dp[i] = 1;
            } else {
                dp[i] = maxLis + 1;
            }
            sum[i] += dp[i];
        }
        //LDS starting from each point
        dp = new int[n];
        dp[dp.length - 1] = 1;
        sum[sum.length - 1] += 1;
        for(int i=dp.length - 2; i>=0; i--) {
            int maxLds = Integer.MIN_VALUE;
            for(int j=i+1; j<dp.length; j++) {
                if(nums[i] > nums[j]) {
                    maxLds = Math.max(maxLds, dp[j]);
                }
            }
            if(maxLds == Integer.MIN_VALUE) {
                dp[i] = 1;
            } else {
                dp[i] = maxLds + 1;
            }
            sum[i] += dp[i];
        }

        int lbs = Integer.MIN_VALUE;
        for(int i=0; i<sum.length; i++) {
            lbs = Math.max(lbs, sum[i] - 1);
        }
        
        System.out.println("tab:" + lbs);
        
        System.out.println("mem:" + solve(nums, 0, -1, 1, new int[21][21][2]));
    }
    
	//memoization
    private static int solve(int[] nums, int idx, int prev, int dir, int[][][] dp) {
        if(idx == nums.length) {
            return 0;
        }
        if(prev != -1 && dp[idx][prev][dir] != 0) {
            return dp[idx][prev][dir]; 
        }
        
        int inc = 0, exc = 0;
        
        if(dir == 1) {
            if(prev == -1 || nums[idx] > nums[prev]) {
                inc = solve(nums, idx + 1, idx, 1, dp) + 1;
            } else if(nums[idx] < nums[prev]){
                inc = solve(nums, idx + 1, idx, 0, dp) + 1;
            }
            exc = solve(nums, idx + 1, prev, 1, dp);
        } else if(dir == 0) {
            if(nums[idx] < nums[prev]) {
                inc = solve(nums, idx + 1, idx, 0, dp) + 1;
            }
            exc = solve(nums, idx + 1, prev, 0, dp);
        }
        if(prev != -1) {
            dp[idx][prev][dir] = Math.max(inc, exc);
        }
        return Math.max(inc, exc);
    }
}
