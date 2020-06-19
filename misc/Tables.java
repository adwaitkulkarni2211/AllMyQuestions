package misc;

import java.util.Scanner;

public class Tables {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		int i=2,a=0,j;
		for(i=1;i<=10;i++)
		{
			for(j=1;j<=20;j++)
			{
				a = a + i;
				System.out.print(" " +a+ " ");
			}
			a = 0;
			System.out.println();
		}
	}
}
