package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ZeroTripletSum {
	public static boolean twoSum(int a[], int x, int i) {
		int j = a.length - 1;
		
		while(i < j) {
			if(a[i] + a[j] > x) {
				
				j--;
			}
			else if(a[i] + a[j] < x) {
				
				i++;
			}
			else {
				System.out.print(a[i] + " "+ a[j]);
				return true;
		
			}
		}
		return false;
	}
	public static boolean zeroSumTriplet(int a[], int n) {
		Arrays.sort(a);
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\nThe triplet is:");
		for(int i=0; i<n-2; i++) {
			
			if(twoSum(a, -a[i], i+1)) {
				System.out.print(" "+ a[i]);
				System.out.println();
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements in the array: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the elements");
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		if(zeroSumTriplet(a,n)) {
			System.out.println("Hence, exists.");
		}
		else
			System.out.println("Hence, doesn't exist.");
		sc.close();
	}
}

