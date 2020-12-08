package dynamicProgramming;
import java.util.*;
public class ClimbingStairs {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        double start = System.currentTimeMillis();
        System.out.println(climbingStairs(n, new int[n+1]));
        double end = System.currentTimeMillis();
        System.out.println("memoised time: " + (end - start));
        start = System.currentTimeMillis();
        System.out.println(climbingStairsTab(n));
        end = System.currentTimeMillis();
        System.out.println("tabulated time: " + (end - start));
    }
    
	public static int climbingStairs(int n, int[] qb) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (qb[n] != 0) {
            //System.out.println(qb[n]);
            return qb[n];
        }

        int cp1 = climbingStairs(n - 1, qb);
        int cp2 = climbingStairs(n - 2, qb);
        int cp3 = climbingStairs(n - 3, qb);
        
        int count = cp1 + cp2 + cp3;

        qb[n] = count;
        return count;
    }
    
    public static int climbingStairsTab(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<dp.length; i++) {
            if(i == 1) {
                dp[i] = dp[i-1];
            } else if(i == 2) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        System.out.println();
        for(int i=0; i<dp.length; i++) {
        	System.out.print(dp[i] +  " ");
        }
        System.out.println();
        return dp[n];
    }
}
