package patterns;

import java.util.Scanner;

public class StarTriangleVerticllyInvertedWithSpaces {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i,j;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		for(i=0;i<n;i++)
		{
			for(j=0;j<i;j++)
			{
				System.out.print("  ");
			}
			for(j=0;j<n-i;j++)
			{
				//if(j>=i)
				System.out.print("* ");
			}
			System.out.println();
		}

	}

}
