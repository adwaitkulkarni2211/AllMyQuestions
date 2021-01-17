package practice;
import java.util.*;
public class CardForFriend_CF_693_Div3 {
	public static boolean canCut(long w, long h, long n) {
		long count = 1;
		if(n == 1) {
			return true;
		}
		while(h > 0 && w > 0) {
			if(w % 2 == 0) {
				w = w / 2;
				count = count * 2;
			} else if(h % 2 == 0) {
				h = h / 2;
				count = count * 2;
			} else {
				break;
			}
			
			if(count >= n) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			long w = sc.nextInt(), h = sc.nextInt(), n = sc.nextInt();
			boolean ans = canCut(w, h, n);
			if(ans == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		sc.close();
	}

}
