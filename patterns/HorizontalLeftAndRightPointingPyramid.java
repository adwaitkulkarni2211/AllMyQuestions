package patterns;

import java.util.Scanner;

public class HorizontalLeftAndRightPointingPyramid {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i, j;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		int p = n;
		int l = n;
		int k = n;
		n = (2*n) - 1;
		for(i=0;i<n;i++)
		{
			if(i<(n/2)+1)
			{
				for(j=0;j<p-1;j++)
				{
					System.out.print("  ");
				}
				p--;
				for(j =0; j<=i; j++)
				    System.out.print("* ");
			}
			else
			{
				for(j = 0; j<i - k + 1; j++)
					System.out.print("  ");
				for(j=0; j<l-1;j++)
				{
					System.out.print("* ");
				}
				l--;
			}
			System.out.println();
		}

	}

}
