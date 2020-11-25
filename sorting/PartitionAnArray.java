package sorting;
import java.util.*;
public class PartitionAnArray {
	public static void partition(int[] a, int pivot) {
        //write your code here
        int i = 0, j = a.length - 1;
        while (i<=j) {
            //System.out.println("in while");
            if (a[i] >= pivot && a[j] <= pivot) {
                //System.out.println("in 1st if");
                swap(a, i, j);
                i++;
                j--;
            } else if (a[i] <= pivot && a[j] <= pivot) {
                //System.out.println("in 2nd if");
                i++;
            } else if (a[i] >= pivot && a[j] >= pivot) {
                //System.out.println("in 3rd if");
                j--;
            } else if (a[i] <= pivot && a[j] >= pivot) {
                //System.out.println("in 4th if");
                i++;
                j--;
            }
        }

    }
	
	public static void partitionPepcoding(int[] a, int pivot) {
        //write your code here
        int i = 0, j = 0;
        while (i < a.length) {
            if (a[i] > pivot) {
                i++;
            } else {
                swap(a, i, j);
                i++;
                j++;
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = scn.nextInt();
        scn.close();
        //partition(arr, pivot);
        partitionPepcoding(arr, pivot);
        print(arr);
    }
}
