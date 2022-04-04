package hashMapsAndHeaps2;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target <= startFuel) {
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int i = 0, currRange = startFuel, stops = 0;
        
        while(true) {
            while(i < stations.length && stations[i][0] <= currRange) {
                pq.add(stations[i][1]);
                i++;
            }
            
            if(pq.isEmpty()) {
                break;
            }
            int maxFuel = pq.peek();
            pq.remove();

            currRange += maxFuel;
            stops++;
            //System.out.println("currRange: " + currRange + " stops: " + stops + " pq: " + pq + " i: " + i);
            if(currRange >= target) {
                return stops;
            }
        }
        
        return -1;
    }
}
