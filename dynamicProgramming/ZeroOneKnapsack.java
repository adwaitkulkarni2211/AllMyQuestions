package dynamicProgramming;
import java.util.*;
public class ZeroOneKnapsack {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        int wt[] = new int[n];
        int val[] = new int[n];
        for(int i=0; i<n; i++) {
        	System.out.println("Enter the value and weight for item " + i);
            val[i] = sc.nextInt();
            wt[i] = sc.nextInt();
        }
        System.out.println("Enter the max capacity of knapsack: ");
        int maxWt = sc.nextInt();
        sc.close();
        System.out.println(solve(wt, val, n, maxWt));
        System.out.println(solve(wt, val, maxWt, 0, new int[n+1][maxWt + 1]));
    }
    
    private static int solve(int[] w, int v[], int n, int wt) {
        int[][] dp = new int[n+1][wt+1];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(j < w[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    //if batsman does not bat
                    int dnb = dp[i-1][j];
                    //if batsman does bat
                    int db = dp[i-1][j - w[i-1]] + v[i-1];
                    
                    dp[i][j] = Math.max(dnb, db);
                }
            }
        }
        
        for(int i=0; i<dp.length; i++) {
        	for(int j=0; j<dp[0].length; j++) {
        		System.out.print(dp[i][j] + " ");
        	}
        	System.out.println();
        }
        
        return dp[n][wt];
    }
    
    //memoization
    private static int solve(int[] wt, int[] val, int maxWt, int idx, int dp[][]) {
        if(idx == wt.length) {
            return 0;
        }
        
        if(dp[idx][maxWt] != 0) {
            return dp[idx][maxWt];
        }
        
        if(maxWt >= wt[idx]) {
            int in = solve(wt, val, maxWt - wt[idx], idx + 1, dp) + val[idx];
            int out = solve(wt, val, maxWt, idx + 1, dp);
            dp[idx][maxWt] = Math.max(in, out);
            display(dp, idx, maxWt);
            return dp[idx][maxWt];
        } else {
            dp[idx][maxWt] = solve(wt, val, maxWt, idx + 1, dp);
            display(dp, idx, maxWt);
            return dp[idx][maxWt];
        }
    }
    
    private static void display(int[][] a, int idx, int maxWt) {
    	System.out.println("dp[" + idx + "][" + maxWt + "]: ");
    	for(int i=0; i<a.length; i++) {
    		for(int j=0; j<a[i].length; j++) {
    			System.out.print(a[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}
