package dynamicProgramming;
import java.util.*;
public class CoinChangeCombination {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int i=0; i<n; i++) {
            for(int j=a[i]; j<dp.length; j++) {
                dp[j] += dp[j - a[i]];
            }
            for(int k=0; k<dp.length; k++) {
            	System.out.print(dp[k] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[target]);
    }
}
