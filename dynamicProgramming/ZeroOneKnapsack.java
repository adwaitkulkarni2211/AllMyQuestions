package dynamicProgramming;
import java.util.*;
public class ZeroOneKnapsack {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n], w = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    int val = w[i - 1];
                    //System.out.println("val: " + val);        
                    if (j >= val) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - val] + v[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        // for(int i=0; i<n + 1; i++) {
        //     for(int j=0; j<target + 1; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);

    }
}
