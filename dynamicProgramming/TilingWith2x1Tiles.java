package dynamicProgramming;
import java.util.*;
public class TilingWith2x1Tiles {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] qb = new int[n+1];
        System.out.println(tiles(n, qb));
        
        //using tabulation
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
    //Using memoization recursion
    public static int tiles(int n, int[] qb) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }
        if(qb[n] != 0) {
            return qb[n];
        }
        
        int n1 = tiles(n-1, qb);
        int n2 = tiles(n-2, qb);
        int total = n1 + n2;
        qb[n] = total;
        return total;
    }
}
