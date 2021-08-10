package dynamicProgramming2;
import java.util.*;
public class MaximumNonOverlappingBridges_BuildingBridges {
	public static class Pair implements Comparable<Pair>{
        int nb, sb;
        
        Pair(int nb, int sb) {
            this.nb = nb;
            this.sb = sb;
        }
        
        public int compareTo(Pair o) {
            if(o.nb != this.nb) {
                return this.nb - o.nb;
            } else {
                return this.sb - o.sb;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] bridges = new Pair[n];
        for(int i=0; i<n; i++) {
            bridges[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        sc.close();
        
        Arrays.sort(bridges);
        
        int[] dp = new int[n];
        
        dp[0] = 1;
        int ans = 1;
        for(int i=1; i<dp.length; i++) {
            int maxLis = Integer.MIN_VALUE;
            for(int j=0; j<i; j++) {
                if(bridges[i].sb > bridges[j].sb) {
                    maxLis = Math.max(maxLis, dp[j]);
                }
            }
            if(maxLis == Integer.MIN_VALUE) {
                dp[i] = 1;
            } else {
                dp[i] = maxLis + 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
