package dynamicProgramming;
import java.util.*;
public class UnboundedKnapsack {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n], w = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();
        int[] dp = new int[target + 1];
        for(int i=0; i<w.length; i++) {
            for(int j=w[i]; j<dp.length; j++) {
               dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
            for(int k=0; k<dp.length; k++) {
            System.out.print(dp[k] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[target]);
    }
}
