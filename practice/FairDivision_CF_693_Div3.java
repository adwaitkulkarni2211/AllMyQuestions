package practice;
import java.util.*;

public class FairDivision_CF_693_Div3 {
	public static int sumArr(int[] a) {
		int sum = 0;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	public static boolean canDivide(int[] a, int n) {
		int sum = sumArr(a);
		System.out.println("sum: " + sum);
		if(sum % 2 != 0) {
			return false;
		} else {
			Arrays.sort(a);
			HashMap<String, Integer> hs = new HashMap<>();
			hs.put("Alice", 0);
			hs.put("Bob", 0);
			int i = 0;
			
			while(hs.get("Alice") < (sum / 2) && i < a.length) {
				hs.put("Alice", hs.get("Alice") + a[i]);
				i++;
				System.out.println("Alice: " + hs.get("Alice"));
			}
			
			while(hs.get("Bob") < (sum / 2) && i < a.length) {
				hs.put("Bob", hs.get("Bob") + a[i]);
				i++;
				System.out.println("Bob: " + hs.get("Bob"));
			}
			
			if(hs.get("Alice") == hs.get("Bob")) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			boolean ans = canDivide(a, n);
			if(ans == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}
