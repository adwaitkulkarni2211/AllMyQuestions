package dynamicProgramming;
import java.util.*;
public class PaintFence {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.close();
        int same = k;
        int diff = k * (k-1);
        int total = same + diff;
        for(int i=3; i<=n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }
        System.out.println(total);
    }
}
