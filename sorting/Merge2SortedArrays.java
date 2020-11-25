package sorting;
import java.util.*;
public class Merge2SortedArrays {
	public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        //write your code here
        int i = 0, j = 0, k = 0;
        int ans[] = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
        	System.out.println("in first while");
            if (a[i] < b[j]) {
            	System.out.println("in 1st if");
                ans[k] = a[i];
                i++;
                k++;
            } else if (b[j] < a[i]) {
            	System.out.println("in 2nd if");
                ans[k] = b[j];
                j++;
                k++;
            }
            else if (b[j] == a[i]) {
                ans[k] = b[j];
                k++;
                j++;
                ans[k] = a[i];
                i++;
                k++;
            }
        }
        while (i < a.length) {
        	System.out.println("int second while");
            ans[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
        	System.out.println("in third while");
            ans[k] = b[j];
            j++;
            k++;
        }
        return ans;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        scn.close();
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }
}
