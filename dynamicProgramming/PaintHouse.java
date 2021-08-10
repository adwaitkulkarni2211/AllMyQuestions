package dynamicProgramming;
import java.util.*;
public class PaintHouse {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][3];
        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int[][] dp= new int[n][3];
        dp[0][0] = a[0][0];
        dp[0][1]= a[0][1];
        dp[0][2] = a[0][2];
        for(int i=1; i<n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + a[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + a[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + a[i][2];
        }
        int min = Math.min(dp[n-1][0], dp[n-1][1]);
        min = Math.min(min, dp[n-1][2]);
        System.out.println(min);
        System.out.println();
         for(int i=0; i<n; i++) {
             for(int j=0; j<3; j++) {
                 System.out.print(dp[i][j] + " ");
             }
             System.out.println();
         }
         System.out.println(solve(a, 0, 0, new int[1001][3]));
    }
	
	//memoization
	private static int solve(int[][] cost, int idx, int prev, int[][] dp) {
        if(idx == cost.length) {
            return 0;
        }
        
        if(dp[idx][prev] != -1) {
            return dp[idx][prev];
        }
        
        //prev = 0 -> red, 1 -> blue, 2 -> green
        int r = Integer.MAX_VALUE,g = Integer.MAX_VALUE,b = Integer.MAX_VALUE;
        
        if(idx == 0) {
            r = solve(cost, idx + 1, 0, dp) + cost[idx][0];
            b = solve(cost, idx + 1, 1, dp) + cost[idx][1];
            g = solve(cost, idx + 1, 2, dp) + cost[idx][2];
        } else {
            if(prev == 0) {
                b = solve(cost, idx + 1, 1, dp) + cost[idx][1];
                g = solve(cost, idx + 1, 2, dp) + cost[idx][2];
            } else if(prev == 1) {
                r = solve(cost, idx + 1, 0, dp) + cost[idx][0];
                g = solve(cost, idx + 1, 2, dp) + cost[idx][2];
            } else if(prev == 2) {
                r = solve(cost, idx + 1, 0, dp) + cost[idx][0];
                b = solve(cost, idx + 1, 1, dp) + cost[idx][1];
            }    
        }
        
        return dp[idx][prev] = Math.min(r, Math.min(g, b));
    }
}
