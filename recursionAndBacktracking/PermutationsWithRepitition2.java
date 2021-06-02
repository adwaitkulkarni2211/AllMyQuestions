package recursionAndBacktracking;
import java.util.*;
public class PermutationsWithRepitition2 {
	List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        HashMap<Integer, Integer> lastOccurence = new HashMap<>();
        for(int n: nums) {
            lastOccurence.put(n, -1);
        }
        
        solve(0, nums, lastOccurence, new Integer[nums.length]);
        
        return ans;
    }
    //levels -> chars, options -> boxes
    private void solve(int idx, int[] nums, HashMap<Integer, Integer> lastOccurence, Integer[] boxes) {
        if(idx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int n: boxes) {
                temp.add(n);
            }
            ans.add(temp);
            return;
        }
        
        int n = nums[idx];
        int lo = lastOccurence.get(n);
        
        for(int i=lo+1; i<boxes.length; i++) {
            if(boxes[i] == null) {
                boxes[i] = n;
                lastOccurence.put(n, i);
                solve(idx + 1, nums, lastOccurence, boxes);
                lastOccurence.put(n, lo);
                boxes[i] = null;
            }
        }
    }
}
