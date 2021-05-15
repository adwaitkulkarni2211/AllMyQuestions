package recursionAndBacktracking;
import java.util.*;
public class Combinations {
	List<List<Integer>> ret;
    public List<List<Integer>> combine(int n, int k) {
        ret = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            nums.add(i);
        }
        solve(nums, k, new ArrayList<>());
        return ret;
    }
    
    public void solve(List<Integer> nums, int k, List<Integer> asf) {
    	if(asf.size() == k) {
            List<Integer> temp = new ArrayList<>(asf);
            ret.add(temp);
            return;
        }
        
        for(int i=0; i<nums.size(); i++) {
            asf.add(nums.get(i));
            List<Integer> roa = new ArrayList<>();
            for(int j=i+1; j<nums.size(); j++) {
                roa.add(nums.get(j));
            }
            solve(roa, k, asf);
            asf.remove(asf.size() - 1);
        }
    }
}
