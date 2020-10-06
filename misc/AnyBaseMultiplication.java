package misc;
import java.util.*;
public class AnyBaseMultiplication {
	
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        scn.close();
        long start = System.currentTimeMillis();
        int d = getProduct(b, n1, n2);
        System.out.println(d);
        long end = System.currentTimeMillis();
        System.out.println("time taken for my function: "+ (end - start));
        start = System.currentTimeMillis();
        int dSumeet = getProductSumeet(b, n1, n2);
        System.out.println(dSumeet);
        end = System.currentTimeMillis();
        System.out.println("time taken for Sumeet's function: "+ (end - start));
    }
	
	 public static int getProductSumeet(int b, int n1, int n2){
	     int rv = 0;
	     int p = 1;
	     while(n2 > 0){
	        int d2 = n2 % 10;
	        n2 = n2 / 10;

	        int pwd = getProductWithDigit(b, n1, d2);
	        rv = getSum(b, rv, p * pwd);
	        p = p * 10;
	     }

	     return rv;
	 }

	 public static int getProductWithDigit(int b, int n1, int d2){
	     int rv = 0, c = 0, p = 1, d;
	     while(n1 > 0 || c > 0){
	        int d1 = n1 % 10;
	        n1 = n1 / 10;
	       int r = d1 * d2 + c;
	       d = r % b;
	       c = r / b;
	       rv += d * p;
	       p = p * 10;
	     }

	     return rv;
	 }

    public static int getSum(int b, int n1, int n2) {
        int sum = 0, power = 0, dig = 0, place = 0;
        while (n1 != 0 || n2 != 0) {
            dig += (n1 % 10) + (n2 % 10);
            if (dig >= b) {
                place = dig - b;
                dig = 1;
            } else {
                place = dig;
                dig = 0;
            }
            sum += place * (int)(Math.pow(10, power));
            power++;
            n1 = n1 / 10;
            n2 = n2 / 10;
        }
        if (dig == 1)
            sum += (int) Math.pow(10, power);
        return sum;
    }

    public static int getProduct(int b, int n1, int n2) {
        int min = Math.min(n1, n2), max = Math.max(n1, n2), product = 0;
        for (int i = 0; i < min; i=(getSum(b,i,1))) {
            product = getSum(b, product, max);
        }
        return product;
    }

	
}
