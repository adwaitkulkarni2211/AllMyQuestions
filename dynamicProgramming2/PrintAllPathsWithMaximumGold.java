package dynamicProgramming2;
import java.io.*;
import java.util.*;

public class PrintAllPathsWithMaximumGold {

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
    
    public static void solve(int cost[][], int n, int m) {
        int[][] dp = new int[n][m];
        
        for(int j=m-1; j>=0; j--) {
            for(int i=n-1; i>=0; i--) {
                if(j == m - 1) {
                    dp[i][j] = cost[i][j];
                } else if(i == n - 1) {
                    dp[i][j] = Math.max(dp[i-1][j+1], dp[i][j+1]) + cost[i][j];
                } else if(i == 0) {
                    dp[i][j] = Math.max(dp[i+1][j+1], dp[i][j+1]) + cost[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j+1], Math.max(dp[i+1][j+1], dp[i][j+1])) + cost[i][j];
                }
            }
        }
        int maxGold = Integer.MIN_VALUE;
        Queue<Pair> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            if(dp[i][0] > maxGold) {
                maxGold = dp[i][0];
                q.clear();
                q.add(new Pair(i, 0, i + ""));
            } else if(maxGold == dp[i][0]) {
                q.add(new Pair(i, 0, i + ""));
            }
        }
        System.out.println(maxGold);
        
        //bfs
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(rem.j == m - 1) {
                System.out.println(rem.psf);
            } else if(rem.i == n - 1) {
                if(dp[rem.i-1][rem.j+1] > dp[rem.i][rem.j+1]) {
                    q.add(new Pair(rem.i-1, rem.j+1, rem.psf + " d1"));
                } else if(dp[rem.i-1][rem.j+1] < dp[rem.i][rem.j+1]) {
                    q.add(new Pair(rem.i, rem.j+1, rem.psf + " d2"));
                } else {
                    q.add(new Pair(rem.i-1, rem.j+1, rem.psf + " d1"));
                    q.add(new Pair(rem.i, rem.j+1, rem.psf + " d2"));
                }
            } else if(rem.i == 0) {
                if(dp[rem.i+1][rem.j+1] < dp[rem.i][rem.j+1]) {
                    q.add(new Pair(rem.i, rem.j+1, rem.psf + " d2"));
                } else if(dp[rem.i+1][rem.j+1] > dp[rem.i][rem.j+1]) {
                    q.add(new Pair(rem.i+1, rem.j+1, rem.psf + " d3"));
                } else {
                    q.add(new Pair(rem.i, rem.j+1, rem.psf + " d2"));
                    q.add(new Pair(rem.i+1, rem.j+1, rem.psf + " d3"));
                }
            } else {
                int max = Math.max(dp[rem.i-1][rem.j+1], Math.max(dp[rem.i+1][rem.j+1], dp[rem.i][rem.j+1]));
                
                if(max == dp[rem.i-1][rem.j+1]) {
                    q.add(new Pair(rem.i-1, rem.j+1, rem.psf + " d1"));
                }
                if(max == dp[rem.i][rem.j+1]) {
                    q.add(new Pair(rem.i, rem.j+1, rem.psf + " d2"));
                }
                if(max == dp[rem.i+1][rem.j+1]) {
                    q.add(new Pair(rem.i+1, rem.j+1, rem.psf + " d3"));
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
