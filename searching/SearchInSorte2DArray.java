package searching;
import java.util.*;
public class SearchInSorte2DArray {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();;
            }
        }
        int i=0, j = a[0].length - 1, x = sc.nextInt();
        sc.close();
        while(i<n && j >= 0) {
            if(x == a[i][j]) {
                System.out.println(i);
                System.out.println(j);
                return;
            } else if(x < a[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Not Found");
    }
}
