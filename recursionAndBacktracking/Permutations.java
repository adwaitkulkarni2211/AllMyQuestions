package recursionAndBacktracking;
import java.util.*;
public class Permutations {
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
