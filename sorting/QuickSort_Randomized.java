package sorting;
import java.util.*;
public class QuickSort_Randomized {
	public static void random(int arr[], int lo, int hi) {
		Random rand= new Random();
        int pivot = rand.nextInt(hi - lo) + lo;
         
        int temp1 = arr[pivot]; 
        arr[pivot] = arr[hi];
        arr[hi] = temp1;
	}
	
	public static void sort(int arr[], int low, int high) {
		if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println("pivot index: " + pi + " pivot: " + arr[pi]);
            
            System.out.println("The array after partitioning is: ");
            print(arr, low, high);
            System.out.println();
 
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {
    	random(arr,low,high);
        int pivot = arr[high];
     
 
        int i = (low-1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }

    public static void print(int[] arr, int low, int high) {
    	for(int i=low; i<=high; i++) {
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
        scn.close();
        sort(arr, 0, arr.length - 1);
        print(arr, 0, arr.length - 1);
    }
}
