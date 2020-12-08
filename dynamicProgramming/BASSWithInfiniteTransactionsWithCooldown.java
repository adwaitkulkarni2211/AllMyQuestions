package dynamicProgramming;
import java.util.*;
public class BASSWithInfiniteTransactionsWithCooldown {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int obsp = -a[0], ossp = 0, ocsp = 0;
        for (int i = 1; i < a.length; i++) {
            int newbsp = 0, newssp = 0, newcsp = 0;

            if (ocsp - a[i] > obsp) {
                newbsp = ocsp - a[i];
            } else {
                newbsp = obsp;
            }

            if (obsp + a[i] > ossp) {
                newssp = obsp + a[i];
            } else {
                newssp = ossp;
            }

            if (ossp > ocsp) {
                newcsp = ossp;
            } else {
                newcsp = ocsp;
            }
            // System.out.println(" " + newbsp + " " + newssp + " " + newcsp);
            // System.out.println();
            ossp = newssp;
            obsp = newbsp;
            ocsp = newcsp;
        }
        System.out.println(ossp);

    }

}