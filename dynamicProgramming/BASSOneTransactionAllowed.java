package dynamicProgramming;
import java.util.*;
public class BASSOneTransactionAllowed {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int dp[] = new int[n];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<dp.length; i++) {
            min = Math.min(min, a[i]);
            dp[i] = a[i] - min;
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
