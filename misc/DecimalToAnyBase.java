package misc;
import java.util.*;
public class DecimalToAnyBase {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal number and the base you wanto convert it to: ");
        int n = sc.nextInt(), b = sc.nextInt();
        sc.close();
        System.out.println(getValueInBase(n, b));
    }

    public static int getValueInBase(int n, int b) {
        int temp = n, sum = 0, power = 0;
        while(temp != 0) {
            int r = temp % b;
            sum = sum + r * (int)(Math.pow(10, power));
            power++;
            temp = temp / b;
        }
        return sum;
    }
}
