package recursionAndBacktracking;

public class MaxNumberAfterKSwaps {
	static String max;
    public static String findMaximumNum(String str, int k) {
        max = str;
        solve(str, k);
        return max;
    }
    
    public static void solve(String str, int k) {
        if((new java.math.BigInteger(str)).compareTo(new java.math.BigInteger(max)) > 0) {
            max = str;
        }
        if(k == 0) {
            return;
        }
        for(int i=0; i<str.length(); i++) {
            int maxDig = Integer.MIN_VALUE, idx = 0;
            for(int j=i+1; j<str.length(); j++) {
                maxDig = Math.max(maxDig, Integer.parseInt(str.substring(j, j+1)));
                if(maxDig == Integer.parseInt(str.substring(j, j+1))) {
                    idx = j;
                }
            }
            String afterSwap;
            if(maxDig > Integer.parseInt(str.substring(i, i+1))) {
                afterSwap = str.substring(0, i) + maxDig + str.substring(i+1, idx)
                        + str.charAt(i) + str.substring(idx + 1);
                solve(afterSwap, k-1);    
            }
        }
    }
}
