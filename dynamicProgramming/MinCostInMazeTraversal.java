package dynamicProgramming;
import java.util.*;
public class MinCostInMazeTraversal {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] a = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int dp[][] = new int[n][m];
        dp[n-1][m-1] = a[n-1][m-1];
        int min = 0;
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
            	//System.out.print("in inner for i: " + i + " j: " + j);
                if(i == n-1 && j == m-1) {
                	System.out.println();
                    continue;
                }
                if(i == a.length-1) {
                	//System.out.print(" and i = a.length\n");
                    dp[i][j] = a[i][j] + dp[i][j+1];
                } else if(j == a[0].length - 1) {
                	//System.out.print(" and j = a[0].length\n");
                    dp[i][j] = a[i][j] + dp[i + 1][j];
                } else {
                	//System.out.print(" and in else\n");
                    min = Math.min(dp[i+1][j], dp[i][j+1]);
                    dp[i][j] = a[i][j] + min;    
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[0][0]);
        
    }
}
