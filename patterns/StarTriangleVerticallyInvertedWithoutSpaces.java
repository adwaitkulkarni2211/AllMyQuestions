package patterns;

import java.util.Scanner;

public class StarTriangleVerticallyInvertedWithoutSpaces {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i,j;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		int k = n;
		for(i=0;i<n;i++)
		{
			for(j=0;j<k;j++)
			{
				System.out.print("* ");
			}
			k--;
			System.out.println();
		}

	}

}
