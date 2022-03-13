package hashMapsAndHeaps2;

import java.util.HashMap;

public class LongestSubarrayWithSumEqualToK {
	public static int lenOfLongSubarr (int nums[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, ans = 0;
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            
            if(map.containsKey(sum - k)) {
                int currLength = i - map.get(sum - k);
                ans = Math.max(ans, currLength);
            }
            
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return ans;
    }
}
