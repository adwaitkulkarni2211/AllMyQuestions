package arrays;
import java.util.*;
public class ShellRotate {
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
        int s = sc.nextInt();
        int r = sc.nextInt();
        sc.close();
        rotateShell(a, s, r);
        display(a);

    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void rotateShell(int[][] arr, int s, int r) {
        int[] oned = fillOnedFromShell(arr, s);

        rotate(oned, r);

        fillShellFromOned(arr, s, oned);
    }
    public static int[] reverse(int a[], int left, int right) {
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            right--;
            left++;
        }
        return a;
    }

    public static void rotate(int[] a, int k) {
        k = k % a.length;
        if (k < 0)
            k = k + a.length;
        a = reverse(a, 0, a.length - k - 1);
        a = reverse(a, a.length - k, a.length - 1);
        a = reverse(a, 0, a.length - 1);
    }

    public static int[] fillOnedFromShell(int[][] a, int s) {
        int minr = s - 1, minc = s - 1, idx = 0;
        int maxr = a.length - s, maxc = a[0].length - s;
        
        //size = (2 * (maxr - minr + 1)) + (2 * (maxc - minc)) - 4
        //     = 2maxr - 2minr + 2 + 2maxc - 2minc - 4
        //     = 2 * (maxr - minr + maxc - minc)
        int sz = 2 * (maxr - minr + maxc - minc);
        System.out.println("size of shell and 1d array: " + sz);
        int[] oned = new int[sz];

        //left wall
        for (int i = minr, j = minc; i <= maxr; i++) {
            oned[idx] = a[i][j];
            idx++;
        }
        minc++;
        //bottom wall
        for (int i = maxr, j = minc; j <= maxc; j++) {
            oned[idx] = a[i][j];
            idx++;
        }
        maxr--;
        //right wall
        for (int i = maxr, j = maxc; i >= minr; i--) {
            oned[idx] = a[i][j];
            idx++;
        }
        maxc--;
        //top wall
        for (int i = minr, j = maxc; j >= minc; j--) {
            oned[idx] = a[i][j];
            idx++;
        }
        minr++;
        
        System.out.println("The 1d array is: ");
        for(int i=0; i<oned.length; i++) {
        	System.out.print(oned[i] + " ");
        }
        System.out.println("\n");
        return oned;
    }

    public static void fillShellFromOned(int[][] a, int s, int[] oned) {
        int minr = s - 1, minc = s - 1, idx = 0;
        int maxr = a.length - s, maxc = a[0].length - s;

        //left wall
        for (int i = minr, j = minc; i <= maxr; i++) {
            a[i][j] = oned[idx];
            idx++;
        }

        //bottom wall
        for (int i = maxr, j = minc + 1; j <= maxc; j++) {
            a[i][j] = oned[idx];
            idx++;
        }

        //right wall
        for (int i = maxr - 1, j = maxc; i >= minr; i--) {
            a[i][j] = oned[idx];
            idx++;
        }

        //top wall
        for (int i = minr, j = maxc - 1; j >= minc + 1; j--) {
            a[i][j] = oned[idx];
            idx++;
        }
    }
}







