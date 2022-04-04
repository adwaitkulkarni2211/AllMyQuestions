package hashMapsAndHeaps2;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
	long minCost(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int i=0; i<arr.length; i++) {
            pq.add(arr[i]);
        }
        
        long totalCost = 0;
        
        while(pq.size() > 1) {
            long val1 = pq.remove();
            long val2 = pq.remove();
            
            long sum = val1 + val2;
            
            totalCost += sum;
            
            pq.add(sum);
        }
        
        return totalCost;
    }
}
