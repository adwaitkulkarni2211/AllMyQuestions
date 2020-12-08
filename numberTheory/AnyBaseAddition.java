package numberTheory;
import java.util.*;
public class AnyBaseAddition {
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        scn.close();
        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    public static int getSum(int b, int n1, int n2) {
        int sum = 0, power = 0, dig = 0, place = 0;
        while (n1 != 0 || n2 != 0) {
            dig = dig + (n1 % 10) + (n2 % 10);
            if (dig >= b) {
                place = dig - b;
                dig = 1;
            } else {
                place = dig;
                dig = 0; 
            }
            System.out.print("dig: "+ dig);
            sum += place * (int)(Math.pow(10, power));
            System.out.print("  sum: "+ sum);
            System.out.print("  power: "+power + "\n");
            power++;
            n1 = n1 / 10;
            n2 = n2 / 10;
        }
        if(dig == 1)
        	sum += (int)Math.pow(10, power);
        return sum;
    }
}
