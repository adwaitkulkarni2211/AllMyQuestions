package misc;
import java.util.*;
public class AnyBaseSubtraction {
	
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        scn.close();
        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    public static int getDifference(int b, int n1, int n2) {
        int sum = 0, power = 0, borrow = 0, ans;
        while(n2>0) {
        	int d1  = n1 % 10;
        	int d2 = n2 % 10;
        	n1 = n1/10;
        	n2 = n2/10;
        	d2 = d2 + borrow;
        	if(d2 >= d1) {
        		borrow = 0;
        		ans = d2 - d1;
        	}
        	else {
        		borrow = -1;
        		ans = d2 + b - d1;
        	}
        	sum += ans * (int)(Math.pow(10, power));
        	power++;
        }
        return sum;
    }
	
}
