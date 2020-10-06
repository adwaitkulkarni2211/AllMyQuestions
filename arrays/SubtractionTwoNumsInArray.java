package arrays;
import java.util.*;
public class SubtractionTwoNumsInArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int b[] = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();
        int sub[] = new int[m]; 
        int ans = 0, borrow = 0;
        n -= 1;
        for (int i = m - 1; i >= 0; i--) {
            b[i] = b[i] + borrow;
            if (n < 0) {
                ans = b[i];
                borrow = 0;
            }
            else {
                if (b[i] < a[n]) {
                    borrow = -1;
                    ans = b[i] + 10 - a[n];
                } else {
                    borrow = 0;
                    ans = b[i] - a[n];
                }
            }
            n--;
            sub[i] = ans;
        }
        int count = 0;
        for(int i=0; i<m; i++){
            if(sub[i] == 0) {
                count++;
            } else if(sub[i] > 0) {
                break;
            }
        }
        for(int i=count; i<m; i++) {
            System.out.println(sub[i]);
        }

	}

}
