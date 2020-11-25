package sorting;
import java.util.*;
public class CountSort {
	public static void countSort(int[] arr, int min, int max) {
        //write your code here
        int range = max - min + 1;
        int[] freq = new int[range];
        for(int i=0; i<arr.length; i++) {
            int idx = arr[i] - min;
            freq[idx]++;
        }
        for(int i=1; i<freq.length; i++) {
            freq[i] = freq[i] + freq[i - 1];
        }
        int ans[] = new int[arr.length];
        for(int i=arr.length - 1; i>=0; i--) {
            int idx = freq[arr[i] - min] - 1;
            ans[idx] = arr[i];
            freq[arr[i] - min]--;
        }
        for(int i=0; i<ans.length; i++) {
            arr[i] = ans[i];
        }

    }

    public static void print(int[] arr) {
    	System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        scn.close();
        countSort(arr, min, max);
        print(arr);
    }
}
