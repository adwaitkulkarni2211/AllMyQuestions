package sorting;
import java.util.*;

public class CountSort {

    public static void countSort(int[] arr, int min, int max) {
        //finding range of elements
        int range = max - min + 1;

        //filling the frequency array
        int[] freq = new int[range];
        for (int i = 0; i < arr.length; i++) {
            //index representing arr[i] in freq will be arr[i] - min as min is stored on 0th index
            freq[arr[i] - min]++;
        }

        //prefix sum array represents the last position in the ans array for each element
        int[] preSum = new int[freq.length];
        preSum[0] = freq[0];
        for (int i = 1; i < freq.length; i++) {
            preSum[i] = preSum[i - 1] + freq[i];
        }

        //filling the ans array
        int[] ans = new int[arr.length];
        //going backwards to maintain stability
        for (int i = arr.length - 1; i >= 0; i--) {
            //preSum will contain the last position of the element
            int pos = preSum[arr[i] - min];
            //subtracting 1 because index is 1 less than the position
            ans[pos - 1] = arr[i];
            //decrementing so that the next time the element appears, it is inserted 1 position behind
            preSum[arr[i] - min]--;
        }

        print(ans);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        //print(arr);
    }

}