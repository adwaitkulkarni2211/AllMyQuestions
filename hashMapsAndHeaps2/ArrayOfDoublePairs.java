package hashMapsAndHeaps2;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayOfDoublePairs {
	public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                continue;
            }
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i]) && map.containsKey(2 * arr[i])) {
                if(map.get(arr[i]) > 1) {
                    map.put(arr[i], map.get(arr[i]) - 1);
                } else {
                    map.remove(arr[i]);
                }
                
                if(map.get(2 * arr[i]) > 1) {
                    map.put(2 * arr[i], map.get(2 * arr[i]) - 1);
                } else {
                    map.remove(2 * arr[i]);
                }
            }
        }
        
        if(map.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
