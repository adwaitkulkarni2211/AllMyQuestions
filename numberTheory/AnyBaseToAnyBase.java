package numberTheory;
import java.util.*;
public class AnyBaseToAnyBase {
	
	public static int anyBaseToDecimal(int n, int b) {
        int sum = 0, power = 0;
        while (n != 0) {
            int r = n % 10;
            sum = sum + r * (int)(Math.pow(b, power));
            power++;
            n = n / 10;
        }
        return sum;
    }
	
	public static int decimalToAnyBase(int n, int b) {
        int temp = n, sum = 0, power = 0;
        while(temp != 0) {
            int r = temp % b;
            sum = sum + r * (int)(Math.pow(10, power));
            power++;
            temp = temp / b;
        }
        return sum;
    }
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sourceBase = sc.nextInt(), destBase = sc.nextInt();
        sc.close();
        int dec = anyBaseToDecimal(n, sourceBase);
        int dn = decimalToAnyBase(dec, destBase);
        System.out.println(dn);
    }
}
