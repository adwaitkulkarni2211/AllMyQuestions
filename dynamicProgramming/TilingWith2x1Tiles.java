package dynamicProgramming;
import java.util.*;
public class TilingWith2x1Tiles {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        long[] qb = new long[n+1];
        System.out.println(solve(n, qb));
        
        //using tabulation
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
    //Using memoization, exactly the same as fibonacci
    public static long solve(int w, long[] dp) {
        if(w < 0) {
            return 0;
        }
        if(w == 0) {
            return 1;
        }
        if(dp[w] != 0) {
            return dp[w];
        }
        
        //placing horizontally 2 tiles together
        long hor = solve(w - 2, dp) % 1000000007;
        //placing vertically
        long ver = solve(w - 1, dp) % 1000000007;
        
        return dp[w] = (hor + ver) % 1000000007;
    }
}
