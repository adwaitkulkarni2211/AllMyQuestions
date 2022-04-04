package hashMapsAndHeaps2;
import java.util.*;

public class AvoidFloodInTheCity {
	public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> ts = new TreeSet<>();
        
        int[] ans = new int[rains.length];
        for(int i=0; i<rains.length; i++) {
            if(rains[i] != 0) {
                ans[i] = -1;
                
                if(map.containsKey(rains[i])) {
                    Integer dryDay = ts.ceiling(map.get(rains[i]));
                    if(dryDay != null) {
                        ts.remove(dryDay);

                        ans[dryDay] = rains[i];

                        map.put(rains[i], i);
                    } else {
                        return new int[0];
                    }
                } else {
                    map.put(rains[i], i);
                }
            } else {
                ans[i] = 1;
                ts.add(i);
            }
        }
        
        return ans;
    }
}
