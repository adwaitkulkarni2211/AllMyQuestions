package arrays;
import java.util.*;
public class PrintAllSubSets {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        for(int i=0; i<Math.pow(2, n); i++) {
            String set = "";
            int temp = i;
            for(int j = n - 1; j >= 0; j--) {
                int r = temp % 2;
                temp = temp / 2;
                
                if(r == 0)
                    set = "-\t" + set;
                else
                    set = (a[j] + "\t") + set;
            }
            System.out.println(set);
        }
    }
}
