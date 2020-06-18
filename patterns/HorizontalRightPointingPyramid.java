package patterns;

import java.util.Scanner;

public class HorizontalRightPointingPyramid {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i, j;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		n = 2*n - 1;
		int k = n/2;
		for(i=0;i<n;i++)
		{
			if(i<(n/2)+1)
			{
				for(j=0;j<=i;j++)
					System.out.print("* ");
			}
			else
			{
				for(j=0;j<k;j++)
					System.out.print("* ");
				k--;
			}
			System.out.println();
		}

	}

}
