package patterns;

import java.util.Scanner;

public class Pallindromepyramidofnumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i, j;
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		int k = n;
		int a = n;
		int b = n-1;
		int l = 0;
        for(i=0;i<n;i++)
        {
        		for(j=0;j<k-1;j++)
        			System.out.print("  ");
        		k--;
        		for(j=0;j<=l;j++) {
        			if(j<(l/2)) {
        				System.out.print(a+" ");
        				a++;
        			}
        			else if(j == l/2)
        			System.out.print("0 ");
        	
        			else if(j>l/2) {
        				System.out.print(b +" ");
        				b--;
        			}
        		}
        		a = a - i - 1;
        		b = n-1;
        			l+=2;
        	System.out.println();
        }

	}

}
