package misc;
import java.util.*;
public class PrimeFactorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();
        for(int i=2; i * i <= n; i++) {
        	while(n % i == 0) {
        		n = n / i;
        		System.out.print(i + " ");
        	}
        }
        if(n != 1) {
        	System.out.print(n);
        }
    }
}

