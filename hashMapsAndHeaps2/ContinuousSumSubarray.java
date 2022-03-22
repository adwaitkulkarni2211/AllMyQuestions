package hashMapsAndHeaps2;

import java.util.HashMap;

public class ContinuousSumSubarray {
	public boolean checkSubarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, ans = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            int rem = sum % k;

            if(rem < 0) {
                rem += k;
            }

            if(map.containsKey(rem)) {
                int currLength = i - map.get(rem);
                ans = Math.max(ans, currLength);
            } else {
                map.put(rem, i);
            }
        }
        
        if(ans >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
