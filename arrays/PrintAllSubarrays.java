package arrays;
import java.util.*;
public class PrintAllSubarrays {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        for(int i=0; i<n; i++) {
            int count = i;
            while(count < n) {
                int j = i;
                while(j <= count) {
                    System.out.print(a[j] + "\t");
                    j++;
                }
                count++;
                System.out.println();
            }
        }
    }
}
