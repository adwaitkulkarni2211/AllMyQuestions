package misc;

import java.util.Scanner;

public class PrimenumnerInJava {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a positive integer:");
		int a = sc.nextInt();
		int i,n=0;
		if(a==2)
		{
			System.out.println("PRIME.");
		}
		else
		{		
			for(i=2;i*i<a;i++)
				{
					n = a%i;
					if(n == 0)
					{
						System.out.println("not prime.");
						break;
					}
				}
					if(n!=0)
					{
						System.out.println("PRIME.");
					}
			
		}
	}
}
