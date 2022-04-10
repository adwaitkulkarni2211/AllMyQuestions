package hashMapsAndHeaps2;
import java.util.*;

public class TopKFrequentElements {
	class Pair implements Comparable<Pair>{
        int val, freq;
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
        
        public int compareTo(Pair o) {
            return o.freq - this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int key: map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
        }
        
        int[] ans = new int[k];
        
        for(int i=0; i<k; i++) {
            ans[i] = pq.remove().val;
        }
        
        return ans;
    }
}
