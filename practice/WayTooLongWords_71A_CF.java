package practice;
import java.util.*;
public class WayTooLongWords_71A_CF {
	public static void shorten(String str) {
		if(str.length() > 10) {
			str = str.charAt(0) + "" + (str.length() - 2) + ""  + str.charAt(str.length() - 1);
			System.out.println(str);
		} else {
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-- > 0) {
			String str = sc.next();
			shorten(str);
		}
		sc.close();
	}

}
