package recursionAndBacktracking;
import java.util.*;
public class Permutations {
	//another method from pepcoding, similar code to combinations
	public static void permutations(int cb, int tb, boolean[] items, int ssf, int ts, String asf){
        if(cb > tb) {
            if(ssf == ts) {
                System.out.println(asf);
            }
            return;
        }
        
        for(int i=0; i<items.length; i++) {
            if(items[i] == false) {
                items[i] = true;
                permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
                items[i] = false;
            }
        }
        
        permutations(cb + 1, tb, items, ssf, ts, asf + '0');
    }
	
	//pepcoding's method, easier to understand
	public static void permutations(int[] boxes, int ci, int ti) {
		//ci -> current item
		//ti -> total items
        if(ci > ti) {
            for(int num: boxes) {
                System.out.print(num);
            }
            System.out.println();
            return;
        }
        
        for(int i=0; i<boxes.length; i++) {
            if(boxes[i] == 0) {
                boxes[i] = ci;
                permutations(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }
	//same method used in permutations for a string
	List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> a = new ArrayList<>();
        for(int num: nums) {
            a.add(num);
        }
        solve(a, new ArrayList<>(), nums.length);	//k can be passed as any number less than nums.length
        return list;
    }
    
    public void solve(List<Integer> a, List<Integer> ans, int k) {
        if(ans.size() == k) {
            List<Integer> temp = new ArrayList<>(ans);
            list.add(temp);
            return;
        }
        
        for(int i=0; i<a.size(); i++) {
            int n = a.get(i);
            List<Integer> roa = new ArrayList<>();
            for(int j=0; j<i; j++) {
                roa.add(a.get(j));
            }
            for(int j=i+1; j<a.size(); j++) {
                roa.add(a.get(j));
            }
            ans.add(n);
            solve(roa, ans, k);
            ans.remove(ans.size() - 1);
        }
    }
}
