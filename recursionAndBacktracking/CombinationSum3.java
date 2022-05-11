package recursionAndBacktracking;
import java.util.*;
public class CombinationSum3 {
	class Solution {
	    public List<List<Integer>> combinationSum3(int k, int n) {
	        if(k > n) {
	            return new ArrayList<>();
	        }
	        
	        ans = new ArrayList<>();
	        
	        solve(k, n, 1, new ArrayList<>());
	        
	        return ans;
	    }
	    
	    List<List<Integer>> ans;
	    
	    private void solve(int k, int n, int idx, List<Integer> asf) {
	        if(k == 0) {
	            if(n == 0) {
	                ans.add(new ArrayList<>(asf));
	            }
	        }
	        
	        for(int i = idx; i <= 9; i++) {
	            if(n - i >= 0) {
	                asf.add(i);
	                solve(k - 1, n - i, i + 1, asf);
	                asf.remove(asf.size() - 1);
	            }
	        }
	    }
	}
}
