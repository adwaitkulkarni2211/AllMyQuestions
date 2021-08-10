package dynamicProgramming2;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class PrintAllPathsWithMinimumJumps {
    public static class Pair {
        //i = index, s = size/jumps allowed, j = jumps made to reach top
        int i, s, j;
        String psf;
        
        Pair(int i, int s, int j, String psf) {
            this.i = i;
            this.s = s;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void Solution(int jumps[], int n){
        Integer[] dp = new Integer[n];
        dp[n - 1] = 0;
        
        for(int i=n-2; i>=0; i--) {
            int minJumps = Integer.MAX_VALUE;
            for(int j=1; j<=jumps[i] && i + j < dp.length; j++) {
                minJumps = Math.min(minJumps, dp[i + j]);
                
            }
            if(minJumps == Integer.MAX_VALUE) {
                dp[i] = Integer.MAX_VALUE;
            } else {
                dp[i] = minJumps + 1;    
            }
        }
        System.out.println(dp[0]);
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, jumps[0], dp[0], 0 + ""));
        
        //bfs
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(rem.i == jumps.length - 1) {
                System.out.println(rem.psf + " .");
            }
            
            for(int j=1; j<=jumps[rem.i] && rem.i + j < dp.length; j++) {
                if(dp[rem.i + j] == rem.j - 1) {
                    q.add(new Pair(rem.i + j, jumps[rem.i + j], dp[rem.i + j], rem.psf + " -> " + (rem.i + j)));
                }
            }
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr, n);
        scn.close();
    }
}

