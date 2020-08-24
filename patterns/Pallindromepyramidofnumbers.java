package patterns;
import java.util.Scanner;
public class Pallindromepyramidofnumbers {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a number: ");		
		int n = sc.nextInt(), i, j;
		
        for(i=0;i<n;i++) {
    		int b = n-1, a = n - i;
    		
    		for(j=0;j<n-1;j++) {
    			if(j>=i)        			
    			System.out.print("  ");
    		}
    		
    		for(j=0;j<(2*i)+1;j++) {
    			
    			if(j<(((2*i)+1)/2)) {
    				System.out.print(a+" ");
    				a++;
    			}    			
    			else if(j == ((2*i)+1)/2)
    				System.out.print("0 ");  
    			
    			else if(j>((2*i)+1)/2) {
    				System.out.print(b +" ");
    				b--;
    			}
    		}   		
    		System.out.println();
        }
	}
}
