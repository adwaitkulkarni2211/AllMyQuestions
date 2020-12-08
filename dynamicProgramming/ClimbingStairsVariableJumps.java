package dynamicProgramming;
import java.util.*;		
public class ClimbingStairsVariableJumps {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int dp[] = new int[n+1];
        dp[n] = 1;
        for(int i=n-1; i>=0; i--) {
            for(int j=1; j<=a[i] && i+j<dp.length; j++) {
                dp[i] = dp[i] + dp[i + j];
            }
        }
        System.out.println(dp[0]);
    }
}
