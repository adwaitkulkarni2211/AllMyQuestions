package dynamicProgramming;
import java.util.*;
public class Goldmine {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int dp[][] = new int[n][m];
        dp[n - 1][m - 1] = a[n - 1][m - 1];
        int max = 0;
        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                //System.out.print(" in inner for i: " + i + " j: " + j);
                if (j == a[0].length - 1) {
                	//System.out.println(" in last column.");
                    dp[i][j] = a[i][j];
                } else if (i == a.length - 1) {
                    //System.out.print(" and i = a.length\n");
                    max = Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                    dp[i][j] = a[i][j] + max;
                } else if (i == 0) {
                    //System.out.println(" and i = 0");
                	max = Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
                    dp[i][j] = a[i][j] + max;
                } else {
                    //System.out.print(" and in else\n");
                    max = Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
                    max = Math.max(dp[i - 1][j + 1], max);
                    dp[i][j] = a[i][j] + max;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][0]);
        }
        System.out.println(ans);
    }
}
