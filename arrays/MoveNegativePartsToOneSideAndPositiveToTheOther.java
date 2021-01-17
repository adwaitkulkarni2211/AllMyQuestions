package arrays;
import java.util.*;
public class MoveNegativePartsToOneSideAndPositiveToTheOther {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		partition(a);
		for(int i=0; i<n; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void partition(int[] a) {
		int i = 0, j = 0;
		while(i < a.length) {
			if(a[i] > 0) {
				i++;
			} else {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j++;
			}
		}
	}
}
