package recursionAndBacktracking;
import java.util.*;
public class PermutationsWithRepitition {
	List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int n: nums) {
            if(fmap.containsKey(n)) {
                fmap.put(n, fmap.get(n) + 1);
            } else {
                fmap.put(n, 1);
            }
        }
        
        solve(0, nums.length, fmap, new ArrayList<>());
        
        return ans;
    }
    //levels -> boxes, options -> chars
    private void solve(int cb, int tb, HashMap<Integer, Integer> fmap, List<Integer> asf) {
        if(cb == tb) {
            List<Integer> temp = new ArrayList<>(asf);
            ans.add(temp);
            return;
        }
        for(int n: fmap.keySet()) {
            if(fmap.get(n) > 0) {
                fmap.put(n, fmap.get(n) - 1);
                asf.add(n);
                solve(cb + 1, tb, fmap, asf);
                asf.remove(asf.size() - 1);
                fmap.put(n, fmap.get(n) + 1);
            }
        }
    }
}
