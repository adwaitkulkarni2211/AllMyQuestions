package recursionAndBacktracking;
import java.util.*;
public class CombinationSum {
	List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] a, int sum) {
        Arrays.sort(a);
        solve(a, 0, sum, new ArrayList<>());
        return ans;
    }
    
     void solve(int[] a, int start, int sum, ArrayList<Integer> ssf) {
         int total = total(ssf);
        if(total > sum) {
            return;
        }
        if(total == sum) {
            ans.add(new ArrayList<>(ssf));
            return;
        }
        for(int i=start; i<a.length; i++) {
            int num = a[i];
            if(total + num <= sum) {
                ssf.add(num);
                solve(a, i, sum, ssf);
                ssf.remove(ssf.size() - 1);
            } else {
                break;
            }
        }
    }
     int total(ArrayList<Integer> a) {
        int sum = 0;
        for(int i=0; i<a.size(); i++) {
            sum += a.get(i);
        }
        return sum;
    }
}
