package recursionAndBacktracking;
import java.io.*;
public class CoinChangeCombination1 {
	//subsequence approach, coins choose whether they want to be included or not
	public static void coinChange(int idx, int[] coins, int amtsf, int tamt, String asf){
        if(idx == coins.length) {
            if(amtsf == tamt) {
                System.out.println(asf + ".");
            }
            return;
        }
        
        coinChange(idx + 1, coins, amtsf + coins[idx], tamt, asf + coins[idx] + "-");
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
