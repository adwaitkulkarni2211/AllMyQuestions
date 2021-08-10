package dynamicProgramming;
import java.util.*;
public class ClimbStairsWithMinMoves {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        Integer dp[] = new Integer[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= a[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
        System.out.println(dp[0]);
        
        System.out.println(solve(n, new int[n+1], a, 0));
    }
	
	//recursion
	private static int solve(int n, int[] dp, int[] jumps, int step) {
		if(step > n) {
			return Integer.MAX_VALUE;
		}
		if(step == n) {
			return 0;
		}
		if(dp[step] != 0) {
			return dp[step];
		}
		
		int minJumps = Integer.MAX_VALUE;
		for(int i=1; i<=jumps[step]; i++) {
			minJumps = Math.min(minJumps, solve(n, dp, jumps, step + i));
		}
		
		if(minJumps == Integer.MAX_VALUE) {
			dp[step] = Integer.MAX_VALUE;
		} else {
			dp[step] = minJumps + 1;
		}
		
		return dp[step];
	}
}
