package dynamicProgramming2;

public class OptimalBinarySearchTree {
    void optimalbst(int[] keys, int[] freq, int n) {
        int[][] dp = new int[n][n];
        int[] psa = new int[n];
        psa[0] = freq[0];
        
        for(int i=1; i<n; i++) {
            psa[i] = psa[i-1] + freq[i];
        }
        
        for(int g=0; g<n; g++) {
            for(int i=0, j=g; j<n; i++, j++) {
                if(g == 0) {
                    dp[i][j] = freq[i];
                } else if(g == 1) {
                    int f1 = freq[i];
                    int f2 = freq[j];
                    
                    dp[i][j] = Math.min(f1 + 2 * f2, f2 + 2 * f1);
                } else {
                    int min = Integer.MAX_VALUE;
                    int fs = psa[j] - (i == 0 ? 0 : psa[i - 1]);
                    for(int k=i; k<=j; k++) {
                        int left = k == i ? 0 : dp[i][k - 1];
                        int right = k == j ? 0 : dp[k + 1][j];
                        
                        int tot = left + right + fs;
                        
                        min = Math.min(min, tot);
                    }
                    dp[i][j] = min;
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
