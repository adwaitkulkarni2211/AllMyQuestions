package dynamicProgramming;
import java.util.*;		
public class ClimbingStairsVariableJumps {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int dp[] = new int[n+1];
        dp[n] = 1;
        for(int i=n-1; i>=0; i--) {
            for(int j=1; j<=a[i] && i+j<dp.length; j++) {
                dp[i] = dp[i] + dp[i + j];
            }
        }
        System.out.println(dp[0]);
        
        System.out.println(solve(n, dp, a, 0));
        System.out.println(solve(n, a));
    }
	
	//memoization:
	private static int solve(int n, int[] dp, int[] steps, int step) {
        if(step > n) {
            return 0;
        } else if(step == n) {
            return 1;
        }
        if(dp[step] != 0) {
            return dp[step];
        }
        
        int paths = 0;
        for(int i=1; i<=steps[step]; i++) {
            paths += solve(n, dp, steps, step + i);
        }
        dp[step] = paths;
        
        return dp[step];
    }
	
	//tabulation
	private static int solve(int n, int[] steps) {
		int[] dp = new int[n+1];
		dp[n] = 1;
		
		for(int i=n-1; i>=0; i--) {
			int paths = 0;
			for(int j=1; j<=steps[i] && i + j < dp.length; j++) {
				paths += dp[i + j];
			}
			dp[i] = paths;
		}
		
		return dp[0];
	}
}
