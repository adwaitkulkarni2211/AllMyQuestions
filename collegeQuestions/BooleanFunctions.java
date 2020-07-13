package collegeQuestions;
import java.util.*;
public class BooleanFunctions {
	
	public static void union(int[] a, int[] b) {
		List<Integer> uni = new ArrayList<>();
		for(int i=0;i<a.length;i++) {
			uni.add(a[i]);
		}
		
		for(int i=0;i<b.length;i++) {
			boolean isPresent = false;
			for(int j=0;j<uni.size();j++) {
				if(uni.get(j)==b[i]) {
					isPresent = true;
					break;
				}
			}
			if(!isPresent)
				uni.add(b[i]);
		}
		
		Integer[] array = uni.toArray(new Integer[0]);
		Arrays.sort(array);
		  for (Integer n : array) {
	            System.out.print(n + " ");
	        }
	}
	
	public static void intersection(int[] a, int[] b) {
		List<Integer> inter = new ArrayList<>();
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				if(a[i]==b[j]) {
					inter.add(a[i]);
					break;
				}
			}
		}
		
		Integer[] array = inter.toArray(new Integer[0]);
		Arrays.sort(array);
		  for (Integer n : array) {
	            System.out.print(n + " ");
	        }
	}
	
	public static void difference(int[] a, int[] b) {
		List<Integer> diff = new ArrayList<>();
		
		for(int i=0;i<a.length;i++) {
			boolean present = false;
			for(int j=0;j<b.length;j++) {
				if(a[i]==b[j]) {
					present = true;
					break;
				}
			}
			if(!present)
				diff.add(a[i]);
		}
		
		Integer[] array = diff.toArray(new Integer[0]);
		Arrays.sort(array);
		  for (Integer n : array) {
	            System.out.print(n + " ");
	        }
	}
	
	public static void symDifference(int[] a, int[] b) {
		List<Integer> diff1 = new ArrayList<>();
		List<Integer> diff2 = new ArrayList<>();
		for(int i=0;i<a.length;i++) {
			boolean present = false;
			for(int j=0;j<b.length;j++) {
				if(a[i]==b[j]) {
					present = true;
					break;
				}
			}
			if(!present)
				diff1.add(a[i]);
		}
		for(int i=0;i<b.length;i++) {
			boolean present = false;
			for(int j=0;j<a.length;j++) {
				if(b[i]==a[j]) {
					present = true;
					break;
				}
			}
			if(!present)
				diff2.add(b[i]);
		}
		int a1[] = new int[diff1.size()];
		int a2[] = new int[diff2.size()];
		for(int i=0;i<a1.length;i++) {
			a1[i] = diff1.get(i);
		}
		for(int i=0;i<a2.length;i++) {
			a2[i] = diff2.get(i);
		}
		union(a1,a2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[m];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		for(int i=0;i<m;i++) {
			b[i] = sc.nextInt();
		}
		union(a,b);
		System.out.println();
		intersection(a,b);
		System.out.println();
		difference(a,b);
		System.out.println();
		symDifference(a,b);
	}

}
