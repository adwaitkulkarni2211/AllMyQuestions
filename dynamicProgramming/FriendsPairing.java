package dynamicProgramming;
import java.util.*;
public class FriendsPairing {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2] * (i - 1);
        }
        System.out.println(dp[n]);
        System.out.println(solve(n, new long[1000001]));
    }
	
	//mem
	private static long solve(int n, long[] dp) {
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        
        long single = solve(n - 1, dp);
        long paired = ((n - 1) * solve(n - 2, dp)) % 1000000007;
        
        return dp[n] = (single + paired) % 1000000007;
    }
}
