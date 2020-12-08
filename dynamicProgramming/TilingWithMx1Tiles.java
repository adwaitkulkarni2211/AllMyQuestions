package dynamicProgramming;
import java.util.*;
public class TilingWithMx1Tiles {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.close();
        int[] qb = new int[n + 1];
        System.out.println(tiles(n, m, qb));	//recursion
        //tabulation:
        int[] dp = new int[n + 1];
        for(int i=1; i<=n; i++) {
            if(i < m) {
                dp[i] = 1;
            }else if(i == m) {
                dp[i] = 2;
            }else {
                dp[i] = dp[i-1] + dp[i-m];
            }
            System.out.println("dp[" + i + "]: " + dp[i]);
        }
        System.out.println(dp[n]);
    }
    //memoization recursion
    public static int tiles(int n, int m, int[] qb) {
        if(n < m) {
            return 1;
        }
        if(qb[n] != 0) {
            return qb[n];
        }
        
        int n1 = tiles(n-1, m, qb);
        int n2 = tiles(n-m, m, qb);
        int total = n1 + n2;
        qb[n] = total;
        return total;
    }
}
