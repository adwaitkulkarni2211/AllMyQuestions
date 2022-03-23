package hashMapsAndHeaps2;

import java.util.HashMap;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], true);
        }
        
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i] - 1)) {
                map.put(nums[i], false);
            }
        }
        
        int ans = 0;
        for(int key: map.keySet()) {
            if(map.get(key) == true) {
                int i = key;
                while(map.containsKey(i)) {
                    i++;
                }
                ans = Math.max(ans, i - key);
            }
        }
        
        return ans;
    }
}
