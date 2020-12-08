package numberTheory;
import java.util.*;
public class AnyBaseToDecimal {
	
	public static int getValueIndecimal(int n, int b) {
        int sum = 0, power = 0;
        while (n != 0) {
            int r = n % 10;
            sum = sum + r * (int)(Math.pow(b, power));
            power++;
            n = n / 10;
        }
        return sum;
    }
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number and its base: ");
        int n = scn.nextInt(), b = scn.nextInt();
        scn.close();
        System.out.println(getValueIndecimal(n, b));
	}

}
