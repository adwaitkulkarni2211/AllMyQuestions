package collegeQuestions;
import java.util.*;
public class BooleanFunctions {
	
	public static List<Integer> union(List<Integer> a, List<Integer> b) {
		List<Integer> uni = new ArrayList<>();
		for(int i=0;i<a.size();i++) {
			uni.add(a.get(i));
		}
		
		for(int i=0;i<b.size();i++) {
			boolean isPresent = false;
			for(int j=0;j<uni.size();j++) {
				if(uni.get(j)==b.get(i)) {
					isPresent = true;
					break;
				}
			}
			if(!isPresent)
				uni.add(b.get(i));
		}
		Collections.sort(uni);
		  return uni;
	}
	
	public static List<Integer> intersection(List<Integer> a, List<Integer> b) {
		List<Integer> inter = new ArrayList<>();
		
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<b.size();j++) {
				if(a.get(i)==b.get(j)) {
					inter.add(a.get(i));
					break;
				}
			}
		}
		return inter;
	}
	
	public static List<Integer> difference(List<Integer> a, List<Integer> b) {
		List<Integer> diff = new ArrayList<>();
		
		for(int i=0;i<a.size();i++) {
			boolean present = false;
			for(int j=0;j<b.size();j++) {
				if(a.get(i)==b.get(j)) {
					present = true;
					break;
				}
			}
			if(!present)
				diff.add(a.get(i));
		}
		return diff;
	}
	
	public static List<Integer> symDifference(List<Integer> a, List<Integer> b) {
		List<Integer> diff1 = new ArrayList<>();
		List<Integer> diff2 = new ArrayList<>();
		List<Integer> symDiff = new ArrayList<>();
		diff1 = difference(a,b);
		diff2 = difference(b,a);
		symDiff = union(diff1,diff2);
		return symDiff;
	}
	public static void display(List<Integer> a) {
		System.out.print(a);
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			a.add(x);
		}
		for(int i=0;i<m;i++) {
			int x = sc.nextInt();
			b.add(x);
		}
		sc.close();
		ans = union(a,b);
		display(ans);
		ans = intersection(a,b);
		display(ans);
		ans = difference(a,b);
		display(ans);
		ans = symDifference(a,b);
		display(ans);
	}
}
