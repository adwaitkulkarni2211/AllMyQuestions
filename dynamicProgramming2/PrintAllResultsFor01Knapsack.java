package dynamicProgramming2;
import java.io.*;
import java.util.*;

public class PrintAllResultsFor01Knapsack {
    private static class Pair {
        int i, j;
        String psf;
        Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    
    private static void solve(int[] wt, int[] val, int cap, int n) {
        int[][] dp = new int[n + 1][cap + 1];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if(j - wt[i-1] >= 0) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - wt[i-1]] + val[i-1]);    
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[n][cap]);
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(n, cap, ""));
        
        //bfs
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(rem.i == 0 || rem.j == 0) {
                System.out.println(rem.psf);
            } else {
                int exc = dp[rem.i - 1][rem.j];
                
                if(rem.j - wt[rem.i - 1] >= 0) {
                    int inc = dp[rem.i - 1][rem.j - wt[rem.i - 1]] + val[rem.i - 1];
                    if(dp[rem.i][rem.j] == inc) {
                        q.add(new Pair(rem.i - 1, rem.j - wt[rem.i - 1], rem.i - 1 + " " + rem.psf));
                    }
                }
                if(dp[rem.i][rem.j] == exc) {
                    q.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }
        
        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }
        int cap = Integer.parseInt(br.readLine());
        
        solve(wts, values, cap, n);
    }
}
