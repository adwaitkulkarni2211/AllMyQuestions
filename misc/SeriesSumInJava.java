package misc;

import java.util.Scanner;

public class SeriesSumInJava {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a positive integer:");
		double i,a=1;
		double n = sc.nextInt();
		for(i=2;i<=n;i++)
		{
			a = a + (1/i);
		}
		System.out.println(a);
	}
}
