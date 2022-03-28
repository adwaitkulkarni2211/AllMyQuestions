package searching;
import java.util.*;

public class BinarySearch {

	public static int bin_search(int a[], int k) {
		int med,left, right;
	    left = 0; right = a.length - 1;
	    while(left<=right) {
	        med = (left + right)/2;
	        if(a[med] == k)
	            return med+1;
	        else if(a[med]<k)
	            left = med + 1;
	        else if(a[med]>k)
	            right = med - 1;
		}
	    return -1;	    	  
	}

	public static void main(String[] args) {
		int n = 50;
		int a[] = new int[n];
		Random rand = new Random();
		for(int i=0;i<n;i++) {
			a[i] = rand.nextInt(99);
		}
		Arrays.sort(a);
		int x = rand.nextInt(99);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		int shit = bin_search(a, x);
		System.out.println("The element " + x + " is located at: " + shit);
	}

}
