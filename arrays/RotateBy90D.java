package arrays;
import java.util.*;
public class RotateBy90D {
	
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int b[][] = new int[n][n];
        for (int i = 0, p = a.length - 1; i < n && p >= 0; i++) {
            for (int j = 0, q = 0; j < n && q < a[0].length; j++) {
                b[j][i] = a[p][q];
                q++;
            }
            p--;
        }
        System.out.println();
        display(b);
        long end = System.currentTimeMillis();
        System.out.println("My method: "+ (end - start));
        //Sumeet's method
        //transpose
        start = System.currentTimeMillis();
        for(int i=0; i<a.length; i++) {
        	for(int j = i; j<a[0].length; j++) {
        		int temp = a[i][j];
        		a[i][j] = a[j][i];
        		a[j][i] = temp;
        	}
        }
        //reverse columns
        for(int i=0; i<a.length; i++) {
        	int l = 0, r = a[0].length - 1;
        	while(l < r) {
        		int temp = a[i][l];
        		a[i][l] = a[i][r];
        		a[i][r] = temp;
        		
        		l++;
        		r--;
        	}
        }
        System.out.println();
        display(a);
        end = System.currentTimeMillis();
        System.out.println("Sumeet's method: "+ (end - start));
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
