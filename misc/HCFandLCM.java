package misc;
import java.util.*;
public class HCFandLCM {
	//Brute Force
	public static void brute(int first, int second) {		
	    long startTime = System.currentTimeMillis();
        int j = 0;
        int max = (Math.max(first, second));
        int min = (Math.min(first, second));
        for (int i = min; i > 0; i--) {
            if (first % i == 0 && second % i == 0) {
                j = i;
                break;
            }
        }
        System.out.println(j);
        for (int i = max;; i += max) {
            if (i % min == 0) {
                j = i;
                break;
            }
        }
        System.out.println(j);
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken for brute: " + (endTime - startTime));
	}
		//Optimized using formula:
	public static void optimized(int first, int second) {
		long startTime = System.currentTimeMillis();
		int temp1 = first, temp2 = second;
        while(first % second != 0) {
        	int rem = first % second;
        	first = second;
        	second = rem;
        }
        int hcf = second;
        System.out.println(hcf);
        int lcm = (temp1 * temp2) / hcf;
        System.out.println(lcm);
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken for optimized: " + (endTime - startTime));
        
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int first = sc.nextInt(), second = sc.nextInt();
        sc.close();
        //brute(first, second);
        optimized(first, second);
	}
	
}
