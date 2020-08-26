package misc;
import java.util.*; 

public class Factorial {
	static int findFactorial(int fact, int n)
	{
		int i;
		for (i = n; i != 0; i--)
		{
			fact = fact * i;
		}
		return fact;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fact=1, n, t;
		System.out.println("Enter a number: ");
		n = sc.nextInt();
		sc.close();
		t = findFactorial(fact, n);
		System.out.println("The Factorail is: " + t);
	}

}
