//1. You are given n number of bulbs. They are all switched off. 
//A weird fluctuation in voltage hits the circuit n times. In the 1st fluctuation all bulbs are toggled,
//in the 2nd fluctuation every 2nd bulb is toggled, in the 3rd fluctuation every 3rd bulb is toggled 
//and so on. You've to find which bulbs will be switched on after n fluctuations.
//2. Take as input a number n, representing the number of bulbs.
//3. Print all the bulbs that will be on after the nth fluctuation in voltage.

package misc;
import java.util.*;
public class Bulbs {
	public static void bruteForce(int n) {
		long startTime = System.currentTimeMillis();
		System.out.print(1+ " ");
        for (int i = 1; i <= n; i++) {
            int bulbs = 1;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0 && j != 1) {
                    if (bulbs == 0) {
                        bulbs = 1;
                        if(j==i)
                        	System.out.print(j + " ");
                    } else if (bulbs == 1 ) {
                        bulbs = 0;
                    }
                }                
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Time Taken for brute: " + (endTime - startTime));
	}
	
	public static void optimised(int n) {
		long startTime = System.currentTimeMillis();
		int count = 0;
		for(int i=1; i*i<=n; i++) {
			System.out.print(i*i+ " ");
			count++;
		}
		System.out.println();
		System.out.println("count:" + count);
		long endTime = System.currentTimeMillis();
		System.out.println();
        System.out.println("Time Taken for optimised: " + (endTime - startTime));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        bruteForce(n);
       System.out.println();
        optimised(n);
	}

}
