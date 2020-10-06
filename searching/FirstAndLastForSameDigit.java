package searching;
import java.util.*;
public class FirstAndLastForSameDigit {
	public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        sc.close();
        int left = 0, right = n - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int front = mid, back = mid;
            if (x > a[mid]) {
                left = mid + 1;
            } else if (x < a[mid]) {
                right = mid - 1;
            } else if (x == a[mid]) {
                while (a[front] == x)
                    front--;
                while (a[back] == x)
                    back++;
                System.out.println(front + 1);
                System.out.println(back - 1);
                break;
            }
        }
        if (x != a[mid]) {
        	System.out.println(-1);
            System.out.println(-1);
        }
    }
}
