package arrays;
import java.util.*;
public class DiagonalTraversal {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), c = 0;
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = c;
                c++;
            }
        }
        sc.close();
        int i = 0, j = i, tempj = j, tempn = n, count = 0;
        long start = System.currentTimeMillis();
        while (tempj < n) {
            i = 0;
            j = i + count;
            while (i < tempn) {
                while (j - i == count) {
                    System.out.println(a[i][j]);
                    j++;
                }
                i++;
            }
            tempj++;
            tempn--;
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println("My method: "+ (end - start));
        System.out.println();
        start = System.currentTimeMillis();
        for(int g=0; g<n; g++) {
        	for(int p=0, q=g; q<n; p++, q++) {
        		System.out.println(a[p][q]);
        	}
        }
        end = System.currentTimeMillis();
        System.out.println("Sumeet's method: "+ (end - start));
	}
     
}
