package misc;
import java.util.*;
public class Day11TwoDArrays {
	    public static int maxHourglass(int a[][]) {
	        int sum=-2147483648;
	        for(int i=0;i<4;i++) {
	            for(int j=0;j<4;j++) {
	                int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] +                              a[i+2][j+1] + a[i+2][j+2];
	                if(temp>sum) { 
	                    sum = temp;
	                }
	            }
	        }
	        return sum;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int[][] arr = new int[6][6];

	        for (int i = 0; i < 6; i++) {
	            String[] arrRowItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int j = 0; j < 6; j++) {
	                int arrItem = Integer.parseInt(arrRowItems[j]);
	                arr[i][j] = arrItem;
	            }
	        }
	        System.out.println(maxHourglass(arr));

	        scanner.close();
	    }
	}

