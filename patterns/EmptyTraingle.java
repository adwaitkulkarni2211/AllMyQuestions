package patterns;

import java.util.Scanner;

public class EmptyTraingle {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i, j;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		for(i=0;i<n;i++)
		{
			for(j=0;j<=i;j++)
			{
				if(i!=n-1)
				{
					if(j==0 || j==i)
						System.out.print("* ");
					else
						System.out.print("  "); 
				}
				else
					System.out.print("* ");
			}
			System.out.println();
		}

	}

}
