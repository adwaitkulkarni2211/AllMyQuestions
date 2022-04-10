package hashMapsAndHeaps2;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<stones.length; i++) {
            pq.add(stones[i]);
        }
        
        while(pq.size() > 1) {
            int maxWt = pq.remove();
            int maxWt2 = pq.remove();
            
            if(maxWt != maxWt2) {
                pq.add(maxWt - maxWt2);
            }
        }
        
        if(pq.size() == 1) {
            return pq.remove();
        } else {
            return 0;
        }
    }
}
