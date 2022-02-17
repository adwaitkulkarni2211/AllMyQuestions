package sorting;
import java.util.Scanner;
public class MergeSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		int[] ans = mergeSort(a, 0, a.length - 1);
		System.out.println("\nSorted array is: ");
		for(int i=0; i<n; i++) {
			System.out.print(ans[i] + " ");
		}
	}
	
	public static void display(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static int[] mergeSort(int[] a, int lo, int hi) {
		if(hi == lo) {
			int ret[] = new int[1];
			ret[0] = a[lo];
			return ret;
		}
		
		int mid = (lo + hi) / 2;
		
		int half1[] = mergeSort(a, lo, mid);
		int half2[] = mergeSort(a, mid + 1, hi);
		int sorted[] = mergeTwoArrays(half1, half2);
		
		System.out.print("\nFirst Array: ");
		display(half1);
		System.out.print("\nSecond Array: ");
		display(half2);
		System.out.print("\nMerged Array: ");
		display(sorted);
		System.out.println();
		
		return sorted;
		
	}
	
	public static int[] mergeTwoArrays(int a[], int b[]) {
		int i = 0, j = 0, k = 0;
		int ans[] = new int[a.length + b.length];
		while(i < a.length && j < b.length) {
			if(b[j] < a[i]) {
				ans[k] = b[j];
				j++;
				k++;
			} else {
				ans[k] = a[i];
				i++;
				k++;
			}
		}
		
		while(i < a.length) {
			ans[k] = a[i];
			i++;
			k++;
		}
		while(j < b.length) {
			ans[k] = b[j];
			j++;
			k++;
		}
		
		return ans;
	}
}
