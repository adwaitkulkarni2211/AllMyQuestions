package dynamicProgramming;
import java.util.*;
public class MaxSumNonAdjacentElements {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int inc = a[0], exc = 0;
        for(int i=1; i<a.length; i++) {
            int ninc = exc + a[i];
            int nexc = Math.max(inc, exc);
            
            exc = nexc;
            inc = ninc;
        }
        
        System.out.println(Math.max(exc, inc));
    }
	//memoization (TLE on gfg)
	int solve(int[] nums, int prev, int idx, int[][] dp) {
        if(idx == nums.length) {
            return 0;
        }
        if(dp[idx][prev] != -1) {
            return dp[idx][prev];
        }
        int in, out;
        if(prev == 0) {
            in = solve(nums, 1, idx + 1, dp) + nums[idx];
            out = solve(nums, 0, idx + 1, dp);
        } else {
            in = 0;
            out = solve(nums, 0, idx + 1, dp);
        }
        
        return dp[idx][prev] = Math.max(in, out);
    }
}
