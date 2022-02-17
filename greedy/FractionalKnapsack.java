package greedy;
import java.util.*;
public class FractionalKnapsack {
	public static class item {
		double wt, val;
		
		item(double wt, double val) {
			this.wt = wt;
			this.val = val;
		}
	}
	
	public static class itemComparator implements Comparator<item> {
		public int compare(item a, item b) {
			double vpw1 = a.val / a.wt;
			double vpw2 = b.val / b.wt;
			
			if(vpw1 < vpw2) {
				return 1;
			} else if(vpw2 < vpw1) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cap = sc.nextInt();
		item[] items = new item[n];
		
		for(int i=0; i<n; i++) {
			double wt = sc.nextDouble();
			double val = sc.nextDouble();
			
			items[i] = new item(wt, val);
		}
		sc.close();
		
		double ans = fractionalKnapsack(items, cap);
		
		System.out.println("The best value generated is: " + ans);
	}
	
	public static double fractionalKnapsack(item[] items, int cap) {
		Arrays.sort(items, new itemComparator());
		
		System.out.println("The sorted array according the value / weight is: ");
		for(int i=0; i<items.length; i++) {
			System.out.println("(" + items[i].wt + ", " + items[i].val + ", " + (items[i].val / items[i].wt) + "), ");
		}
		System.out.println();
		
		double currWt = 0;
		double finalVal = 0;
		
		for(int i=0; i<items.length; i++) {
			if(currWt + items[i].wt <= cap) {
				currWt += items[i].wt;
				finalVal = finalVal + items[i].val;
			} else {
				double rem = cap - currWt;
				finalVal += items[i].val / items[i].wt * rem;
				break;
			}
		}
		
		return finalVal;
	}
	
}
