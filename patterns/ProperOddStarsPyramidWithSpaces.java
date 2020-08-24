package patterns;

import java.util.Scanner;

public class ProperOddStarsPyramidWithSpaces {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i, j;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		//int k = n;
		//int p = 0;
        for(i=0;i<n;i++)
        {
        	for(j=0;j<n-1;j++)
        	{
        		if(j>=i)
        		System.out.print("  ");
        	}
        	//k--;
        	for(j=0;j<(2*i)+1;j++)
        	{
        		System.out.print("* ");
        	}
        	//p+=2;
        	System.out.println();
        }

	}

}
