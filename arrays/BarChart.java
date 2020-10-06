package arrays;
import java.util.*;
public class BarChart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
        int n = sc.nextInt(), big = 0;
        int[] a = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < n; i++) {
            if (a[i] > a[big])
                big = i;
        }
        for (int i = a[big]; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if(i <= a[j])
                    System.out.print("*  ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }

	}

}
