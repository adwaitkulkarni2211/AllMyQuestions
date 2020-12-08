package dynamicProgramming;
import java.util.*;
public class BASSInfiniteTransactionAllowed {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        //int dp[] = new int[n];
        int buy = a[0], sell = a[0], i = 1, sum = 0;
        while (i < a.length) {
            if (a[i] >= a[i - 1]) {
                int j = i;
                while (j < a.length && a[j] >= a[j - 1]) {
                    sell = a[j];
                    j++;
                }
                sum = sum + (a[j - 1] - buy);
                System.out.println("sum: " + sum + " buy: " + buy + " sell:" + sell);
                if (j < a.length) {
                    buy = a[j];
                    sell = a[j];
                }
                i = j;
            } else {
                buy = a[i];
                sell = a[i];
                i++;
            }

        }
        System.out.println(sum);
        System.out.println("buy: " + buy + " sell: " + sell);
        
        int bd = 0, sd = 0, profit = 0;
        for(i=1; i<a.length; i++) {
        	if(a[i] >= a[i-1]) {
        		sd++;
        	} else {
        		profit += a[sd] - a[bd];
        		bd = sd = i;
        		System.out.println("profit: " + profit);
        	}
        }
        profit += a[sd] - a[bd];
        System.out.println("pep's profit: " + profit);
    }
}























