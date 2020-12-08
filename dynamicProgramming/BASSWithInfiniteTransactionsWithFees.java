package dynamicProgramming;
import java.util.*;
public class BASSWithInfiniteTransactionsWithFees {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int fee = sc.nextInt();
        sc.close();
        int obsp = -a[0], ossp = 0;
        for(int i=1; i<a.length; i++) {
            int newbsp = 0, newssp = 0;
            //for newbsp:
            if(ossp - a[i] > obsp) {
                newbsp = ossp - a[i];
            } else {
                newbsp = obsp;
            }
            //for newssp
            if(obsp + a[i] - fee > ossp) {
                newssp = obsp + a[i] - fee;
            } else {
                newssp = ossp;
            }
            
            ossp = newssp;
            obsp = newbsp;
        }
        System.out.println(ossp);
    }
}
