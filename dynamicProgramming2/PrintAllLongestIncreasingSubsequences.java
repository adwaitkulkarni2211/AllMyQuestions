package dynamicProgramming2;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
public class PrintAllLongestIncreasingSubsequences{
    //l = length, i = index, v = 
    public static class Pair {
        int l;
        int i;
        int v;
        String psf;
        
        Pair(int l, int i, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
        
    public static void solution(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int lis = 1;
        dp[0] = 1;
        
        for(int i=1; i<dp.length; i++) {
            int maxLis = 0;
            for(int j=0; j<i; j++) {
                if(nums[i] >= nums[j]) {
                    maxLis = Math.max(maxLis, dp[j]);
                }
            }
            
            dp[i] = maxLis + 1;
            
            if(dp[i] > lis) {
                lis = dp[i];
            }
        }
        System.out.println(lis);
        
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0; i<dp.length; i++) {
            if(dp[i] == lis) {
                q.add(new Pair(lis, i, nums[i], nums[i] + ""));       
            }
        }
        
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(rem.l == 1) {
                System.out.println(rem.psf);
            }
            
            for(int j=rem.i-1; j>=0; j--) {
                if(dp[j] == rem.l - 1 && nums[j] <= rem.v) {
                    q.add(new Pair(dp[j], j, nums[j], nums[j] + " -> " + rem.psf));
                }
            }
        }
    }
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}
