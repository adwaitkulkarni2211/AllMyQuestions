package misc;

import java.util.Scanner;

public class PrimenumnerInJava {
	public static void primeUnder(int n) {
		for(int i=2; i<=n; i++) {
			if(isPrime(i) != -1)
				System.out.println(i);
		}
	}
public static int isPrime(int a) {
	boolean Prime = true;
	if(a%2 == 0) {
		Prime = false;
		return -1;
	}
	for(int i=3; i<a; i+=2) {
		if(a%i == 0) {
			Prime = false;
			break;
		}
	}
	if(Prime == true) 
		return a;
	else
		return -1;
}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a positive integer:");
		int a = sc.nextInt();
		sc.close();
		System.out.println("All the prime numbers under "+ a + " are: ");
		System.out.println(2);
		primeUnder(a);
	}
}
