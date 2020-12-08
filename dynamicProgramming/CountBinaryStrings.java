//count Binary Strings with no consecutive 0s
package dynamicProgramming;
import java.util.*;
public class CountBinaryStrings {
	public static void main(String[] args) throws Exception {
        // my approach by figuring out the pattern
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 2;
        dp[2] = 3;
        for(int i=3; i<dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
        
        //recommended approach:
        int[] ezero = new int[n+1];
        int[] eone = new int[n+1];
        ezero[1] = 1;
        eone[1] = 1;
        for(int i=2; i<ezero.length; i++) {
            ezero[i] = eone[i-1];
            eone[i] = ezero[i-1] + eone[i-1];
        }
        System.out.println(ezero[n] + eone[n]);
        
        //without arrays (also recommended):
        int old0 = 1, old1 = 1;
        for(int i=2; i<=n; i++) {
            int new0 = old1;
            int new1 = old0 + old1;
            old0 = new0;
            old1 = new1;
        }
        System.out.println(old0 + old1);
    }
}
