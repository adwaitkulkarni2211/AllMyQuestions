package strings;
import java.util.Scanner;
public class PrintAllPallindromicSubStrings {
	public static boolean isPallindrome(String str) {
		int l = 0, r = str.length() - 1;
		while(l < r) {
			if(str.charAt(l) != str.charAt(r)) {
				return false;
			} else {
				l++;
				r--;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		for(int i=0; i<str.length(); i++) {
			for(int j=i; j<str.length(); j++) {
				String ss = "";
				for(int k=i; k<=j; k++) {
					ss += str.charAt(k);
				}
				if(isPallindrome(ss)) {
					System.out.println(ss);
				}
			}
		}
	}
}
