package dynamicProgramming2;
import java.util.*;
public class CountPalindromicSubsequences {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        
        System.out.println(countPS(str));
    }
	static long mod = 1000000007;
	static long countPS(String str) {
        //System.out.println("len: " + str.length());
        long[][] dp = new long[str.length()][str.length()];
        
        for(int g=0; g<dp.length; g++) {
            for(int i=0, j=g; j<dp[0].length; i++, j++) {
                if(g == 0) {
                    dp[i][j] = 1;
                } else if(g == 1) {
                    if(str.charAt(i) != str.charAt(j)) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 3;
                    }
                } else {
                    if(str.charAt(i) != str.charAt(j)) {
                        //prefix + suffix - mid
                        dp[i][j] = ((dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1]) % mod + mod) % mod;
                    } else {
                        //prefix + suffix + 1
                        dp[i][j] = (dp[i][j-1] + dp[i+1][j] + 1) % mod;
                    }
                }    
            }
        }
        return dp[0][dp.length-1];
    }
}
