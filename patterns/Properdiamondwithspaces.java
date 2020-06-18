package patterns;

import java.util.Scanner;

public class Properdiamondwithspaces {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i, j;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		int k = n;
		int q = n;
		int a = n;
		int l = 0;
		int p = (2*n - 1);
	    n = p;
        for(i=0;i<n;i++)
        {
        	if(i<(n/2)+1)
        	{
        		for(j=0;j<k-1;j++)
        			System.out.print("  ");
        		k--;
        		for(j=0;j<=l;j++)
        			System.out.print("* ");
        		l+=2;
        		for(j=0;j<q-1;j++)
        			System.out.print("  ");
        		q--;
        	}
        	else
        	{
        		for(j=0;j<(i-a+1);j++)
        			System.out.print("  ");
        		for(j=0;j<p-2;j++)
        			System.out.print("* ");
        		p-=2;
        		for(j=0;j<(i-a+1);j++)
        			System.out.print("  ");
        	}
        
        	System.out.println();
        }

	}

}
