package sorting;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i, j,n,small=0,temp;
		System.out.println("Enter the length of array: ");
		n = sc.nextInt();
		int a[] = new int[n];
	    System.out.println("Enter all the elements:");
	    for(i = 0; i < n; i++)
	    {
	            a[i] = sc.nextInt();
        }
	    for(i=0;i<n-1;i++)
	    { 
	    	small=i;
		    for(j=i;j<n;j++) 
		    {
		    	if(a[j]<a[small])
		    		   small=j;
		    	System.out.print(a[j]+" ");
		    }
		    System.out.println();
		    temp = a[i];
   	    	a[i]=a[small];
   	    	a[small] = temp;
		 
	    }
	    System.out.println("The sorted array is:");
	    for(int item: a)                             //enhanced for loop
	    	System.out.print(" "+ item);

	}

}
