package hashMapsAndHeaps2;
import java.util.*;

public class CountOfSubarraysWithSumEqualTo0 {
	public static long findSubarray(long[] arr ,int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int sum = 0, count = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            
            if(map.containsKey(sum)) {
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        
        return count;
    }
}
