package queues2;
import java.util.*;
public class SumOfAllMinAndMaxElementsOfAllSubArraysOfSizeK {
	
	public static void solve(int[] a, int k) {
		Queue<Integer> q = new ArrayDeque<>();
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int smin = Integer.MAX_VALUE - 1, smax = Integer.MIN_VALUE + 1;
		for(int i=0; i<k; i++) {
			q.add(a[i]);
			if(a[i] > max) {
				smax = max;
				max = a[i];
			} else if(a[i] > smax) {
				smax = a[i];
			}
			if(a[i] < min) {
				smin = min;
				min = a[i];
			} else if(a[i] < smin) {
				smin = a[i];
			}
		}
		int sum = 0;
		for(int i=k; i<a.length; i++) {
			int winSum = min + max;
			System.out.println("winSum: " + winSum);
			sum += winSum;
			int rem = q.remove();
			if(rem == max) {
				max = smax;
			}
			if(rem == min) {
				min = smin;
			}
			q.add(a[i]);
			if(a[i] > max) {
				smax = max;
				max = a[i];
			} else if(a[i] > smax) {
				smax = a[i];
			}
			if(a[i] < min) {
				smin = min;
				min = a[i];
			} else if(a[i] < smin) {
				smin = a[i];
			}
		}
		sum += min + max;
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		int[] a = {2, 5, -1, 7, -3, -1, -2};
		int k = 4;
		solve(a, k);
	}

}
