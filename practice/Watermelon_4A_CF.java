package practice;
import java.util.*;
public class Watermelon_4A_CF {
	public static boolean isDivide(int n) {
		if(n % 2 == 0 && n != 2) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		boolean ans = isDivide(n);
		if(ans == true) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
