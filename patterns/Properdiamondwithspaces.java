package patterns;
import java.util.Scanner;
public class Properdiamondwithspaces {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter a number: ");
		int n = sc.nextInt(), p = (2*n - 1);
        for(int i=0;i<(2*n)-1;i++) {
        	
        	if(i<(p/2)+1) {
        		for(int j=0;j<n-1;j++)
        			if(j>=i)
        				System.out.print("  ");
        		
        		for(int j=0;j<(2*i)+1;j++)
        			System.out.print("* ");
        	}
        	else {
        		for(int j=0;j<(i-n+1);j++)
        			System.out.print("  ");
        		
        		for(int j=0;j<p-2;j++)
        			System.out.print("* ");
        		p-=2;
        	}        
        	System.out.println();
        }
		

        int m = sc.nextInt(), l = m - 2;
        sc.close();
        for (int i = 0; i < m; i++) {
            if (i < (m / 2) + 1) {
                for (int j = 0; j < (m / 2) - i; j++) {
                    System.out.print("\t");
                }
                for (int j = 0; j < (2 * i) + 1; j++) {
                        System.out.print("*\t");
                }
            } else {
                for (int j = 0; j < i - (m/2); j++) {
                        System.out.print("\t");
                }
                for (int j = 0; j < l; j++) {
                        System.out.print("*\t");
                }
                l -= 2;
            }
            System.out.println();
        }
	}
}
