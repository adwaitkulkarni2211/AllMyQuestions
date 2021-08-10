package dynamicProgramming;
import java.util.*;
public class UnboundedKnapsack {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        
        for(int i=0; i<n; i++) {
            val[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            wt[i] = sc.nextInt();
        }
        
        int maxWt = sc.nextInt();
        sc.close();
        
        System.out.println(solve(wt, val, n, maxWt));
    }
    
    private static int solve(int[] wt, int[] val, int n, int maxWt) {
        int dp[] = new int[maxWt + 1];
        
        for(int i=1; i<=n; i++) {
            for(int j=wt[i-1]; j<dp.length; j++) {
                dp[j] = Math.max(dp[j - wt[i-1]] + val[i-1], dp[j]);
            }
        }
        
        return dp[maxWt];
    }
}
