package patterns;
import java.util.*;
public class HourGlass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), p = n, k = 3;
        sc.close();
        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("\t");
            }
            for (int j = 0; j < p; j++) {
                System.out.print("*\t");
                p -= 2;
            }
            System.out.println();
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("\t");
            }
            for (int j = 0; j < k; j++) {
                System.out.print("*\t");
                k += 2;
            }
            System.out.println();
        }


	}

}
