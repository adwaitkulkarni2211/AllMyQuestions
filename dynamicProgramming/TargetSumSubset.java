package dynamicProgramming;
import java.util.*;
public class TargetSumSubset {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();
        boolean[][] dp = new boolean[n+1][target+1];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                if(i==0 && j==0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    if(dp[i-1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        int val = a[i-1];
                        if(j >= val) {
                            if(dp[i-1][j - val] == true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[a.length][target]);
    }
}
