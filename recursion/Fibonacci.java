package recursion;
import java.util.*;
public class Fibonacci {
	public static int fibo(int n) {
		if(n==0 || n==1) {
			return n;
		}
		
		int f1  = fibo(n-1);
		int f2 = fibo(n-2);
		
		return f1 + f2;
	}
	
	public static int fiboMemoized(int n, int[] q) {
		if(n==0 || n==1) {
			return n;
		}
		if(q[n] != 0) {
			return q[n];
		}
		
		int f1 = fiboMemoized(n-1, q);
		int f2 = fiboMemoized(n-2, q);
		q[n] = f1 + f2;
		
		return q[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		double start = System.currentTimeMillis();
		System.out.println(fibo(n));
		double end = System.currentTimeMillis();
		System.out.println("noraml time: " + (end - start));
		start = System.currentTimeMillis();
		System.out.println(fiboMemoized(n, new int[n+1]));
		end = System.currentTimeMillis();
		System.out.println("dp time: " + (end - start));		
	}
}
