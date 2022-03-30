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
        int x = sc.nextInt();
        sc.close();
        
        System.out.println(logarithmic(a, x));
        System.out.println(linear(a, x));
    }
    
    private static boolean logarithmic(int[][] matrix, int target) {
    	//convert 2d to 1d
        int left = 0, right = (matrix.length * matrix[0].length) - 1;
        
        while(left <= right) {
            int midBox = left + (right - left) / 2;
            
            int midRow = midBox / matrix[0].length;
            int midCol = midBox % matrix[0].length;
            
            if(target < matrix[midRow][midCol]) {
                right--;
            } else if(target > matrix[midRow][midCol]) {
                left++;
            } else {
                return true;
            }
        }
        
        return false;
    }
    
    private static boolean linear(int[][] a, int x) {
    	int i=0, j = a[0].length - 1;
    	while(i < a.length && j >= 0) {
            if(x == a[i][j]) {
                return true;
            } else if(x < a[i][j]) {
                j--;
            } else {
                i++;
            }
        }
    	
    	return false;
    }
}
