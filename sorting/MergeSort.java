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
		System.out.println("Sorted array is: ");
		for(int i=0; i<n; i++) {
			System.out.print(ans[i] + " ");
		}
	}
	
	public static int[] mergeSort(int[] a, int lo, int hi) {
		if(hi == lo) {
			int ret[] = new int[1];
			ret[0] = a[lo];
			return ret;
		}
		
		int a1[] = mergeSort(a, lo, (lo + hi) / 2);
		int a2[] = mergeSort(a, ((lo + hi) / 2) + 1, hi);
		return mergeTwoArrays(a1, a2);
		
	}
	
	public static int[] mergeTwoArrays(int a[], int b[]) {
		int i = 0, j = 0, k = 0;
		int ans[] = new int[a.length + b.length];
		while(i < a.length && j < b.length) {
			if(a[i] < b[j]) {
				ans[k] = a[i];
				i++;
				k++;
			} else if(b[j] < a[i]) {
				ans[k] = b[j];
				j++;
				k++;
			} else {
				ans[k] = a[i];
				i++;
				k++;
				ans[k] = b[j];
				j++;
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
