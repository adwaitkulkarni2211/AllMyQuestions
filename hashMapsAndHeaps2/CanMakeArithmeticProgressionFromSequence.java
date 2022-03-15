package hashMapsAndHeaps2;

import java.util.HashMap;

public class CanMakeArithmeticProgressionFromSequence {
	public boolean canMakeArithmeticProgression(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //finding min and second min
        int min = Integer.MAX_VALUE, sdMin = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < min) {
                sdMin = min;
                min = arr[i];
            } else if(arr[i] < sdMin) {
                sdMin = arr[i];
            }
            
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        int diff = sdMin - min;
        
        
        for(int i=1; i<=arr.length; i++) {
            int iTerm = min + ((i - 1) * diff); //ith term in AP
            if(!map.containsKey(iTerm) || map.get(iTerm) == 0) {
                return false;
            } else {
                map.put(iTerm, map.get(iTerm) - 1);
            }
        }
        
        return true;
    }
}
