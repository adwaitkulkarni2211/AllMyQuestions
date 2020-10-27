package arrays;
import java.util.*;
public class NearestLargerValue {
	public static int bin_search(int a[], int k) {
		int med,left, right;
	    left = 0; right = a.length - 1;
	    while(left<=right) {
	        med = (left + right)/2;
	        if(a[med] == k)
	            return med;
	        else if(a[med]<k)
	            left = med + 1;
	        else if(a[med]>k)
	            right = med - 1;
		}
	    return -1;	    	  
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		do {
			String cont = sc.next();
			int x = sc.nextInt(); 
			if(cont == "e") {
				break;
			}
			int temp = a[x];
			Arrays.sort(a);
			int ind = bin_search(a, temp);
			try {
				if(ind == a.length) {
					System.out.println(-1);
				}
				System.out.println(a[ind + 1]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("You have entered the wrong index");
			}
		}while(true);
	}

}
