package recursionAndBacktracking;
import java.util.*;
public class PartitionEqualSumKSubsets {
	public boolean canPartitionKSubsets_better(int[] nums, int k) {
        int sum = sum(nums);
        if(k == 1) {
    	    return true;
    	} else if(k > nums.length || sum % k != 0) {
    	    return false;
    	}
    	
        int target = sum / k;
        
        return solve(nums, target, new int[k], 0);
    }
    
    private boolean solve(int[] nums, int target, int[] sets, int idx) {
        if(idx == nums.length) {
            return true;
        }
        
        for(int i=0; i<sets.length; i++) {
            if(sets[i] + nums[idx] > target) {
                continue;
            } else if(sets[i] + nums[idx] <= target) {
                sets[i] += nums[idx];
                if(solve(nums, target, sets, idx + 1)) {
                    return true;
                }
                sets[i] -= nums[idx];
            }
            
            if(sets[i] == 0) break;
        }
        return false;
    }	
	
	boolean ans = false;
    public boolean canPartitionKSubsets(int[] a, int k) {
        if(k == 1) {
    	    return true;
    	} else if(k > a.length || sum(a) % k != 0) {
    	    return false;
    	}
    	int[] subsetSum = new int[k];
    	ArrayList<ArrayList<Integer>> sets = new ArrayList<>();
    	for(int i=0; i<k; i++) {
    	    sets.add(new ArrayList<>());
    	}
    	solve(a, 0, k, sets, subsetSum, 0);
    	return ans;
    }
    
    public int sum(int[] a) {
        int res = 0;
        for(int n: a) {
            res += n;
        }
        return res;
    }
    
    public void solve(int[] a, int idx, int k, ArrayList<ArrayList<Integer>> sets, int[] subsetSum, int subsetSofar) {
        if(idx == a.length) {
            if(subsetSofar == k) {
                boolean flag = true;
                for(int i=0; i<subsetSum.length - 1; i++) {
                    if(subsetSum[i] != subsetSum[i+1]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    ans = true;
                }
            }
            return;
        }
        
        for(int i=0; i<sets.size(); i++) {
            if(sets.get(i).size() > 0) {
                sets.get(i).add(a[idx]);
                subsetSum[i] += a[idx];
                solve(a, idx+1, k, sets, subsetSum, subsetSofar);
                if(ans == true) return;
                subsetSum[i] -= a[idx];
                sets.get(i).remove(sets.get(i).size() - 1);
            } else {
                sets.get(i).add(a[idx]);
                subsetSum[i] += a[idx];
                solve(a, idx+1, k, sets, subsetSum, subsetSofar + 1);
                if(ans == true) return;
                subsetSum[i] -= a[idx];
                sets.get(i).remove(sets.get(i).size() - 1);
                //breaking to avoid generating the same sets. if a number is added for the
                //first time to a set, it means it hasn't been added to the sets after it.
                //if we don't break out here, the number will be added to all the remaining 
                //sets and it'll be as if we're doung the same thing again and again
                break;
            }
        }
    }
}
