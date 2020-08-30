package misc;
import java.util.*;
public class PrimeFactorization {
	public static boolean isPrime(int a) {
        boolean Prime = true;
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                Prime = false;
                break;
            }
        }
        if (Prime == true)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), temp = n;
        sc.close();
        int i = 2;
        while (temp >= 0 || isPrime(i) == true) {
            if (temp % i != 0) {
                i++;
                if(temp == 1) {
                    break;
                }
            } else {
                temp = temp / i;
                System.out.print(i + " ");

            }
        }
    }
}

