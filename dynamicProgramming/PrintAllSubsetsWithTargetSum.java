package dynamicProgramming;
import java.io.*;
import java.util.*;

public class PrintAllSubsetsWithTargetSum {

    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    
    public static void tss(int[] nums, int tar, int n) {
        boolean[][] dp = new boolean[n+1][tar+1];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    if(j-nums[i-1] >= 0) {
                        dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(n, tar, ""));
        
        //bfs
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(rem.i == 0 || rem.j == 0) {
                System.out.println(rem.psf);
                
            } else {
                if(rem.j - nums[rem.i - 1] >= 0 && dp[rem.i - 1][rem.j - nums[rem.i - 1]] == true) {
                    //if rem is included in the subset
                    q.add(new Pair(rem.i - 1, rem.j - nums[rem.i - 1], rem.i - 1 + " " + rem.psf));
                }
                if(dp[rem.i - 1][rem.j] == true) {
                    //if rem is not included in the subset
                    q.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }
            }
        }
        
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        tss(arr, tar, n);
    }
}
