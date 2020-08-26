package arrays;
import java.util.*;
public class MatrixMultiplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i, j, m1,n1,m2,n2, sum=0;
		int a[][] = new int[5][5];
		int b[][] = new int[5][5];
		int c[][] = new int[5][5];
		System.out.println("Enter the number of rows and coloumns in 1st matrix: ");
		 m1 = sc.nextInt();
		 n1 = sc.nextInt();
		System.out.println("Enter the number of rows and coloumns in 1st matrix: ");
		 m2 = sc.nextInt();
		 n2 = sc.nextInt();
		if(n1 != m2)
		{
			System.out.println("number of rows is not equal to number of columns.");
		}
		else
		{
			System.out.println("Enter the elemnts of 1st matrix:");
			for(i=0;i<m1;i++)
			{
				for(j=0;j<n1;j++)
					a[i][j] = sc.nextInt();
			}
			System.out.println("Enter the elemnts of 2nd matrix:");
			for(i=0;i<m2;i++)
			{
				for(j=0;j<n2;j++)
					b[i][j] = sc.nextInt();
			}
			for(i=0;i<m1;i++)
			{
				for(j=0;j<n2;j++)
				{
					for(int k=0;k<n1;k++)
					{
						sum = sum + a[i][k]*b[k][j];
					}
					c[i][j]=sum;
					sum=0;
				}
			}
			System.out.println("The product matrix is:");
			for(i=0;i<m1;i++)
			{
				for(j=0;j<n2;j++)
				{
					System.out.print(c[i][j]+ " ");
				}
				System.out.println();
			}
			System.out.println("Diagonal elements: ");
			for(i=0;i<m1;i++)
			{
				for(j=0;j<n2;j++)
				{
					if(i==j || j==n2-1-i)
						System.out.print(c[i][j]+ "  ");
					else
						System.out.print("    ");
				}
				System.out.println();
			}			
		}
	}
}
