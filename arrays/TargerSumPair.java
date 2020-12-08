package arrays;
import java.util.*;
public class TargerSumPair {
	public static void targetSumPair(int[] a, int target) {
        //write your code here
        Arrays.sort(a);
        int i = 0, j = a.length - 1;
        while (i<j) {
            if(a[i] + a[j] > target) {
                j--;
            } else if(a[i] + a[j] < target) {
                i++;
            } else {
                System.out.println(a[i] + ", " + a[j]);
                j--;
                i++;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        scn.close();
        targetSumPair(arr, target);
    }
}
