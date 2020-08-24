package patterns;

import java.util.Scanner;

public class HorizontalRightPointingPyramid {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i, j;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		for(i=0;i<(2*n - 1);i++)
		{
			if(i<((2*n - 1)/2)+1)
			{
				for(j=0;j<=i;j++)
					System.out.print("* ");
			}
			else
			{
				for(j=i;j<(2*n - 1);j++)
					if(j>=i)
					System.out.print("* ");
			}
			System.out.println();
		}

	}

}
