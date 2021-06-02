package recursionAndBacktracking;
import java.io.*;
public class CoinChangeProblem_WithRepititionOfCoins {
	//this one is exactly like combination sum
	public static void coinChange_CombinationSum(int idx, int[] coins, int amtsf, int tamt, String asf) {
        if(amtsf > tamt) {
            return;
        }
        if(amtsf == tamt) {
            System.out.println(asf + ".");
            return;
        }
        
        for(int i=idx; i<coins.length; i++) {
            coinChange(i, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
        }
    }
	//here we have the coin choosing whether to be included or not
	public static void coinChange(int idx, int[] coins, int amtsf, int tamt, String asf) {
        if(idx == coins.length) {
            if(amtsf == tamt) {
                System.out.println(asf + ".");
            }
            return;
        }
        
        for(int j=tamt/coins[idx]; j>=1; j--) {
            String part = "";
            for(int k=0; k<j; k++) {
                part += coins[idx] + "-";
            }
            coinChange(idx + 1, coins, amtsf + coins[idx] * j, tamt, asf + part);
        }
        coinChange(idx + 1, coins, amtsf, tamt, asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
    }
}
