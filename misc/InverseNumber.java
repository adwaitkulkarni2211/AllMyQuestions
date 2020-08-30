package misc;
import java.util.*;
public class InverseNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), temp = n;
        sc.close();
        int count = 0;
        while(temp != 0) {
            temp = temp / 10;
            count++;
        }
        System.out.println("count:" + count);
        long sum = 0;
        for(int i=1; i<=count; i++) {
            int r = (int)n % 10;
            System.out.println("r: "+r);
            sum = sum + (i * (long)Math.pow(10, r-1));
            System.out.println("sum: "+ sum);
            n = n / 10;
        }
        System.out.println(sum);

	}

}
