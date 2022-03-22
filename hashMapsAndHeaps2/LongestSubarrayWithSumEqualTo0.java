package hashMapsAndHeaps2;
import java.util.*;

public class LongestSubarrayWithSumEqualTo0 {
	int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0, maxLength = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            
            if(map.containsKey(sum)) {
                int currLength = i - map.get(sum);
                maxLength = Math.max(maxLength, currLength);
            } else {
                map.put(sum, i);
            }
            
            //System.out.println(map);
        }
        
        return maxLength;
    }
}
