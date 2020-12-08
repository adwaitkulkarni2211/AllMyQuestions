package dynamicProgramming;
import java.util.*;
public class CoinChangePermutation {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int amt=1; amt<=target; amt++) {
            for(int coin: a) {
            	System.out.println("For coin: " + coin + " amount: " + amt);
                if(coin <= amt) {
                	System.out.println("as " + coin + " <= " + amt + ", updating dp");
                    int recievedAmt = amt - coin;
                    dp[amt] += dp[recievedAmt];
                } 
            }
            for(int k=0; k<dp.length; k++) {
            	System.out.print(dp[k] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[target]);
    }
}
