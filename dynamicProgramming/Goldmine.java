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
        
        //recursive
        int[][] dp1 = new int[n][m];
        for(int row=0; row<a.length; row++) {
        	ans = Math.max(ans, solve(a, dp1, row, 0));
        }
        System.out.println("Recursive: " + ans);
        
        //new tabulation
        System.out.println("new tabulation: " + solve(a, n, m));
    }
	//Memoization
	private static int solve(int[][] mine, int[][] dp, int row, int col) {
        if(row < 0 || row > mine.length - 1 || col > mine[0].length - 1) {
            return 0;
        }
        if(col == mine[0].length - 1) {
            return mine[row][col];
        }
        if(dp[row][col] != 0) {
            return dp[row][col];
        }
        //upward diagonal
        int ud = solve(mine, dp, row - 1, col + 1);
        //horizontal
        int h = solve(mine, dp, row, col + 1);
        //downward diagonal
        int dd = solve(mine, dp, row + 1, col + 1);
        
        dp[row][col] = Math.max(ud, Math.max(h, dd)) + mine[row][col];
        
        return dp[row][col];
    }
	
	//new tabulation
	private static int solve(int[][] mine, int n, int m) {
        int[][] dp = new int[n][m];
        for(int row=0; row<mine.length; row++) {
            dp[row][m-1] = mine[row][m-1];
        }
        
        for(int col=m-2; col>=0; col--) {
            for(int row=n-1; row>=0; row--) {
                if(row == n-1) {
                    dp[row][col] = Math.max(dp[row-1][col+1], dp[row][col+1]) + mine[row][col];
                } else if(row == 0) {
                    dp[row][col] = Math.max(dp[row+1][col+1], dp[row][col+1]) + mine[row][col];
                } else {
                    dp[row][col] = Math.max(dp[row-1][col+1], Math.max(dp[row][col+1], dp[row+1][col+1])) + mine[row][col];
                }
            }
        }
        
      //find max in the first column
        int ans = Integer.MIN_VALUE;
        for(int row=0; row<mine.length; row++) {
        	ans = Math.max(ans, dp[row][0]);
        }
        return ans;
    }
}
