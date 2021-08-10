package dynamicProgramming2;
import java.util.*;
public class MaximumSumIncreasingSubsequence {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        
        int[] dp = new int[n];
	    dp[0] = nums[0];
	    int ans = nums[0];
	    
	    for(int i=1; i<dp.length; i++) {
	        int maxSum = Integer.MIN_VALUE;
	        for(int j=0; j<i; j++) {
	            if(nums[i] >= nums[j]) {
	                maxSum = Math.max(maxSum, dp[j]);
	            }
	        }
	        if(maxSum == Integer.MIN_VALUE) {
	            dp[i] = nums[i];
	        } else {
	            dp[i] = maxSum + nums[i];
	        }
	        ans = Math.max(ans, dp[i]);
	    }
	    
	    System.out.println(ans);
    }
}
