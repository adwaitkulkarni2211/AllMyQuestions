package dynamicProgramming2;
import java.io.*;
import java.util.*;

public class PrintAllPathsWithMinimumCost {
    private static class Pair {
        String psf;
        int i;
        int j;
        
        public Pair(int i, int j, String psf) {
          this.psf = psf;
          this.i = i;
          this.j = j;
        }
    }
    
    public static void solve(int[][] cost, int n, int m) {
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = cost[n-1][m-1];
        
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                if(i == n - 1 && j == m - 1) {
                    dp[i][j] = cost[i][j];
                } else if(i == n - 1) {
                    dp[i][j] = dp[i][j+1] + cost[i][j];
                } else if(j == m - 1) {
                    dp[i][j] = dp[i+1][j] + cost[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + cost[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0, ""));
        
        //bfs
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(rem.i == n - 1 && rem.j == m - 1) {
                System.out.println(rem.psf);
            } else if(rem.i == n - 1) {
                q.add(new Pair(rem.i, rem.j + 1, rem.psf + "H"));
            } else if(rem.j == m - 1) {
                q.add(new Pair(rem.i + 1, rem.j, rem.psf + "V"));
            } else {
                if(dp[rem.i + 1][rem.j] < dp[rem.i][rem.j + 1]) {
                    q.add(new Pair(rem.i + 1, rem.j, rem.psf + "V"));
                } else if(dp[rem.i + 1][rem.j] > dp[rem.i][rem.j + 1]) {
                    q.add(new Pair(rem.i, rem.j + 1, rem.psf + "H"));
                } else {
                    q.add(new Pair(rem.i + 1, rem.j, rem.psf + "V"));
                    q.add(new Pair(rem.i, rem.j + 1, rem.psf + "H"));
                }    
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];
        
        for (int i = 0; i < n; i++) {
          String str = br.readLine();
          for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
          }
        }
        solve(arr, n, m);
    }

}
