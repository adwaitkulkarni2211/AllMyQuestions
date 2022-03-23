package hashMapsAndHeaps2;

import java.util.HashMap;

public class TrickySortingCost {
	static int sortingCost(int N, int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max = 0;
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i] - 1)) {
                map.put(arr[i], map.get(arr[i] - 1) + 1);
            } else {
                map.put(arr[i], 1);
            }
            
            max = Math.max(max, map.get(arr[i]));
        }
        
        return arr.length - max;
    }
}
