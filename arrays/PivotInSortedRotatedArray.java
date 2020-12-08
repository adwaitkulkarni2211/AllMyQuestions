package arrays;
import java.util.*;
public class PivotInSortedRotatedArray {
	 public static int findPivot(int[] a) {
	        // write your code here
	        int lo = 0, hi = a.length - 1;
	        while (lo < hi) {
	            int mid = (hi + lo) / 2;
	            if(a[mid] < a[hi]) {
	                hi = mid;
	            } else {
	                lo = mid + 1;
	            }
	        }
	        return a[hi];
	    }

	    public static void main(String[] args) throws Exception {
	        Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = scn.nextInt();
	        }
	        scn.close();
	        int pivot = findPivot(arr);
	        System.out.println(pivot);
	    }
}
