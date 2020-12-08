package dynamicProgramming;
import java.util.*;
public class BASSTwoTransactionsAllowed {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int dpl[] = new int[n];
        int maxProfitIfSoldToday = 0, leastsf = a[0];
        for(int i=1; i<a.length; i++) {
            if(a[i] < leastsf) {
                leastsf = a[i];
            }
            maxProfitIfSoldToday = a[i] - leastsf;
            if(maxProfitIfSoldToday > dpl[i-1]) {
                dpl[i] = maxProfitIfSoldToday;
            } else {
                dpl[i] = dpl[i-1];
            }
        }
        
        int[] dpr = new int[n];
        int maxProfitIfBoughtToday = 0, maxat = a[a.length - 1];
        for(int i=a.length - 2; i>=0; i--) {
            if(a[i] > maxat) {
                maxat = a[i];
            }
            maxProfitIfBoughtToday = maxat - a[i];
            if(maxProfitIfBoughtToday > dpr[i+1]) {
                dpr[i] = maxProfitIfBoughtToday;
            } else {
                dpr[i] = dpr[i + 1];
            }
        }
        int ans = 0;
        for(int i=0; i<a.length; i++) {
            if(dpl[i] + dpr[i] > ans) {
                ans = dpl[i] + dpr[i];
            }
        }
        System.out.println(ans);
    }
}
