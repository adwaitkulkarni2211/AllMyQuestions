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
}
