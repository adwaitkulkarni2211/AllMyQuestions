package patterns;

import java.util.Scanner;

public class Patternq11wierdpatternwithnologic {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i, j;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		int k = n;
		int a = 0;
        for(i=0;i<n;i++)
        {
        	for(j=1;j<=k-1;j++)
        		System.out.print("  ");
        	k--;
        	for(j=1;j<=i+1;j++)
        	{
        		if(j==1 || j == i+1)
        		System.out.print("1   ");
        		else if(i == 4 && j == 3)
        			System.out.print("6   ");
        		else if(i==5 && (j == 3 || j == 4))
        			System.out.print("10   ");
        		else
        			System.out.print(a +"   ");
        	}
        	a++;
           	System.out.println();
        }

	}

}
