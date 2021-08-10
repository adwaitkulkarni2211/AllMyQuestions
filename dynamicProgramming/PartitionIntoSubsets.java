package dynamicProgramming;
import java.util.*;
public class PartitionIntoSubsets {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.close();
        long dp[][] = new long[k + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                } else if (j < i) {
                    dp[i][j] = 0;
                } else if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i][j - 1] * i) + dp[i - 1][j - 1];
                }
            }
        }
        System.out.println(dp[k][n]);
        // System.out.println();
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
	
	//mem
	public static long solve(int n, int k, long[][] dp) {
        if(n < 0 || n < k) {
            return 0;
        }
        if(n == 0 || k == 1) {
            return 1;
        }
        if(dp[n][k] != 0) {
            return dp[n][k];
        }
        
        //if n chooses to stay alone in a new set, so the reamining numbers should form k - 1 sets
        long al = solve(n - 1, k - 1, dp);
        //if n chooses to merge with an existing set, so the remaining numbers should form k sets
        long mr = k * solve(n - 1, k, dp);
        
        return dp[n][k] = al + mr;
    }
}
