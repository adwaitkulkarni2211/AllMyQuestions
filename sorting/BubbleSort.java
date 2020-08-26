package sorting;

import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		int i, j,n,temp;
		System.out.println("Enter the length of array: ");
		n = sc.nextInt();
		int a[] = new int[n];
	    System.out.println("Enter all the elements:");
	    for(i = 0; i < n; i++)
	    {
	            a[i] = sc.nextInt();
        }
	    sc.close();
	    for(i=0;i<n-1;i++) //up to n-1 as the last element gets sorted in the first iteration
	    {
	    	boolean sorted = true; //to stop the loop as soon as the array is sorted
	    	for(j=0;j<n-1-i;j++)   //the loop will run only up to the elements that are not sorted
	    	{
	    		if(a[j+1]<a[j])
	    		{
	    			temp = a[j+1];
	    			a[j+1]=a[j];
	    			a[j]= temp;
	    			sorted = false;
	    		}
	    		System.out.print(a[j] + " "); //to show all iterations
	    		if(j==n-2)                    //to print the last element
	    			System.out.print(a[j+1] + " ");
	    	}
	    	System.out.println();
	    	if(sorted)
    			break;
	    }
	    System.out.println("The sorted array is:");
	    for(int item: a)                             //enhanced for loop
	    	System.out.print(" "+ item);
	   
    }
}
