package patterns;

import java.util.Scanner;

public class Properinvertedoddstarspyramidwithspaces {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i, j;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		int p = 2*n - 1;
        for(i=0;i<n;i++)
        {
        	for(j=0;j<i;j++)
        	{
        		System.out.print("  ");
        	}
        	for(j=0;j<p;j++)
        	{
        		System.out.print("* ");
        	}
        	p-=2;
        	System.out.println();
        }

	}

}
