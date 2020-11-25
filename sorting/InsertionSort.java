package sorting;
import java.util.*;
public class InsertionSort {
	public static void insertionSort(int[] arr) {
        //write your code here
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isGreater(arr, j, j + 1)) {
                    swap(arr, j, j + 1);
                } else {
                    break;
                }
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

    // return true if jth element is greater than ith element
    public static boolean isGreater(int[] arr, int j, int i) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
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
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        insertionSort(arr);
        print(arr);
        int[] a = new int[10];
        int l = 0;
        for(int i=10; i>0; i--) {        	
        	a[l] = i;
        	l++;
        }
        System.out.println();
        for(int i=1; i<a.length; i++) {
        	for(int j=i-1; j>=0; j--) {
        		if(a[j + 1] < a[j]) {
        			int temp = a[j+1];
        			a[j+1] = a[j];
        			a[j] = temp;
        		} else {
        			break;
        		}
        		for(int k=0; k<a.length; k++) {
        			System.out.print(a[k] +" ");
        		}
        		System.out.println();        		
        	}
        	System.out.println();
        }
    }
}





















