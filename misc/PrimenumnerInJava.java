package misc;

import java.util.Scanner;

public class PrimenumnerInJava {
	public static boolean isPrime(int a) {
    	boolean Prime = true;
    	for(int i=2; i*i<=a; i++) {
    		if(a%i == 0) {
    			Prime = false;
    			break;
    		}
    	}
    	if(Prime == true) 
    		return true;
    	else
    		return false;
    }
    public static void primeUnder(int low, int high) {
        boolean check = false;
        for(int i=low; i<=high; i++) {
            check = isPrime(i);
            if(check == true) {
                System.out.println(i);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter starting number: ");
        int low = sc.nextInt();
        System.out.println("Enter the ending number: ");
        int high = sc.nextInt();
        sc.close();
        if(low < 2) {
        	low = 2;
        }
        primeUnder(low, high);
    }
}
