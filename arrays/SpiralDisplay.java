package arrays;
import java.util.*;
public class SpiralDisplay {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int minr = 0, maxr = a.length - 1;
        int minc = 0, maxc = a[0].length - 1;
        int count = 0, tot = n * m;
        while(count < tot) {
            //left wall
            for(int i=minr, j=minc; i<=maxr && count < tot; i++) {
                System.out.print(a[i][j] + " ");
                count++;
            }
            minc++;
            //bottom wall
            for(int i=maxr, j=minc; j<=maxc && count < tot; j++) {
                System.out.print(a[i][j] + " ");
                count++;
            }
            maxr--;
            //right wall
            for(int i=maxr, j=maxc; i>=minr && count < tot; i--) {
                System.out.print(a[i][j] + " ");
                count++;
            }
            maxc--;
            //top wall
            for(int i=minr, j=maxc; j>=minc && count < tot; j--) {
                System.out.print(a[i][j] + " ");
                count++;
            }
            minr++;
        }
    }
}
