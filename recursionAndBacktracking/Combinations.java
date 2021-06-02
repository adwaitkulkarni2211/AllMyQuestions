package recursionAndBacktracking;
import java.util.*;
public class Combinations {
	//another method from pepcoding, similar to the first/original one:
	public static void combinations(boolean[] boxes, int ci, int ti, int lb){
        if(ci > ti) {
            String ans = "";
            for(int i=0; i<boxes.length; i++) {
                if(boxes[i] == false) {
                    ans += '-';
                } else {
                    ans += 'i';
                }
            }
            System.out.println(ans);
            return;
        }
        
        for(int i=lb + 1; i<boxes.length; i++) {
        	boxes[i] = true;
            combinations(boxes, ci + 1, ti, i);
            boxes[i] = false;
        }
    }	
	
	//pepcoding's code, much easier, just like subsequence/subset
	public static void combinations(int cb, int tb, int ssf, int ts, String asf){
		//cb -> current box
		//tb -> total boxes
		//ssf -> selections so far
		//ts -> total selections
        if(cb > tb) {
            if(ssf == ts) {
                System.out.println(asf);
            }
            return;
        }
        
        combinations(cb + 1, tb, ssf + 1, ts, asf + 'i');
        combinations(cb + 1, tb, ssf, ts, asf + '-');
    }
	
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
