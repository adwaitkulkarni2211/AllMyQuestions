package patterns;
import java.util.*;
public class Arrow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), p = n, k = 3;
        sc.close();
        for (int i = 0; i < n; i++) {
            if(i<=n/2) {
                for (int j = 0; j < i; j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j < p; j++) {
                    if(i==0)
                        System.out.print("* ");
                    else if(j==0 || j==p-1)
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
                p -= 2;
                System.out.println();
            }
            else {
                for (int j = 0; j < n - i - 1; j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j < k; j++) {
                    System.out.print("* ");
                }
                k += 2;
                System.out.println();
            }
        }
	}
}


