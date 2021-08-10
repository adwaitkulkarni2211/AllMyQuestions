package dynamicProgramming;
import java.util.*;
public class PaintFence {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.close();
        int same = k;
        int diff = k * (k-1);
        int total = same + diff;
        for(int i=3; i<=n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }
        System.out.println(total);
    }
	
	long solve(int n, int k, int color, int count, long[][][] dp) {
        if(n == 0) {
            return 1;
        }
        
        if(dp[n][color][count] != -1) {
            return dp[n][color][count];
        }
        
        long ways = 0;
        for(int i=1; i<=k; i++) {
            if(color == i) {
                if(count == 2) {
                    continue;
                }
                ways += solve(n - 1, k, i, count + 1, dp) % 1000000007; 
            } else {
                ways += solve(n - 1, k, i, 1, dp) % 1000000007;
            }
        }
        
        return dp[n][color][count] = ways % 1000000007;
    }
}
