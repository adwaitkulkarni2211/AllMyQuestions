package recursionAndBacktracking;
import java.util.*;
public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] a) {
        int sum = 0;
        for(int num: a) {
            sum += num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        int[] subsetSum = new int[2];
        @SuppressWarnings("unchecked")
		ArrayList<Integer> [] sets = new ArrayList[2];
        for(int i=0; i<2; i++) {
            sets[i] = new ArrayList<>();
        }
        solve(a, 0, subsetSum, sets);
        if(is == true) {
            return true;
        } else {
            return false;
        }
    }
    
    boolean is = false;
    void solve(int a[], int idx, int[] subsetSum, ArrayList<Integer> [] sets) {
        if(idx == a.length) {
            if(subsetSum[0] == subsetSum[1]) {
                is = true;
            }
            return;
        }
        
        subsetSum[0] += a[idx];
        sets[0].add(a[idx]);
        solve(a, idx+1, subsetSum, sets);
        sets[0].remove(sets[0].size() - 1);
        subsetSum[0] -= a[idx];
        
        subsetSum[1] += a[idx];
        sets[1].add(a[idx]);
        solve(a, idx+1, subsetSum, sets);
        sets[1].remove(sets[1].size() - 1);
        subsetSum[1] -= a[idx];
    }
}
