package searching;

import java.util.Scanner;

public class BinarySearch {

	static int bin_search(int a[], int k)
	{
		int med,left, right;
	    left = 0; right = a.length - 1;
	    while(left<=right)
	    {
	        med = (left + right)/2;
	        if(a[med] == k)
	        {
	            return med+1;
	        }
	        else if(a[med]<k)
	        {
	            left = med + 1;
	        }
	        else if(a[med]>k)
	        {
	            right = med - 1;
	        }     
		}
	    return -1;	    	  
	}

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
				int i;
				int n = sc.nextInt();
				int a[] = new int[n];
				for(i=0;i<n;i++)
				{
					a[i] = sc.nextInt();
				}
				int x = sc.nextInt();
				int shit = bin_search(a, x);
				System.out.println(shit);
	}

}
