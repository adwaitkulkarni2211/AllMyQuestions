package dynamicProgramming;
import java.util.*;
public class BASSKTransactionsAllowed {
	public static void main(String[] args) throws Exception {
        // O(n^3):
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {
            for (int d = 1; d < a.length; d++) {
                int max = dp[t][d - 1];

                for (int pastDay = 0; pastDay < d; pastDay++) {
                    int profitTillLastTransaction = dp[t - 1][pastDay];
                    int profitTth = a[d] - a[pastDay];

                    if (profitTillLastTransaction + profitTth > max) {
                        max = profitTillLastTransaction + profitTth;
                    }
                }
                dp[t][d] = max;
            }
        }
        System.out.println(dp[k][n - 1]);
        
        //More optimized way O(n^2):
        
        int[][] dp2 = new int[k + 1][n];
        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < a.length; d++) {
                if (dp2[t - 1][d - 1] - a[d - 1] > max) {
                    max = dp2[t - 1][d - 1] - a[d - 1];
                }
                if (max + a[d] > dp[t][d - 1]) {
                    dp2[t][d] = max + a[d];
                } else {
                    dp2[t][d] = dp[t][d - 1];
                }
            }
        }
        System.out.println(dp[k][n - 1]);
    }
}
