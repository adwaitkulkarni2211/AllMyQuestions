package dynamicProgramming;
import java.util.*;
public class PaintHouseManyColors {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = a[0][i];
        }
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, minColorIdx = 0;
            for (int k = 0; k < dp[0].length; k++) {
                if(dp[i-1][k] <= min) {
                	min2 = min;
                	min = dp[i-1][k];
                	minColorIdx = k;
                } else if(dp[i-1][k] <= min2) {
                	min2 = dp[i-1][k];
                }
            }
            System.out.println("minColorIdx: " + minColorIdx + " min: " + min + " min2: " + min2);
            for (int j = 0; j < m; j++) {
                if (minColorIdx != j)
                    dp[i][j] = a[i][j] + min;
                else {
                    dp[i][j] = a[i][j] + min2;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < dp[0].length; k++) {
            ans = Math.min(ans, dp[n - 1][k]);
        }
        System.out.println(ans);
        System.out.println("dp:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
