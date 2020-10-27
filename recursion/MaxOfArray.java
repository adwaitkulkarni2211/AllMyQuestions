package recursion;
import java.util.*;
public class MaxOfArray {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int max=maxOfArray(a, 0);
        System.out.println("max element is: "+max);
    }

    public static int maxOfArray(int[] a, int idx){
        if(idx == a.length - 1) {
            return a[idx];
        }
        int max = maxOfArray(a, idx + 1);
        System.out.println(max + " on " + a[idx]);
        if(a[idx] > max) {
            max = a[idx];
        }
        return max;
    }
}
