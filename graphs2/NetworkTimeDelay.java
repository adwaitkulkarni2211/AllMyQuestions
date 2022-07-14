package graphs2;
import java.util.*;

public class NetworkTimeDelay {
	class Solution {
	    public int networkDelayTime(int[][] times, int n, int k) {
	        List<List<List<Integer>>> adj = new ArrayList<>();
	        for(int i = 0; i < n + 1; i++) {
	            adj.add(new ArrayList<>());
	        }
	        for(int i = 0; i < times.length; i++) {
	            List<Integer> edge = new ArrayList<>();
	            edge.add(times[i][1]);
	            edge.add(times[i][2]);
	            
	            adj.get(times[i][0]).add(edge);
	        }
	        
	        return prims(adj, n, k);
	    }
	    
	    class Pair implements Comparable<Pair> {
	        int v, wt;
	        Pair(int v, int wt) {
	            this.v = v;
	            this.wt = wt;
	        }
	        
	        public int compareTo(Pair o) {
	            return this.wt - o.wt;
	        }
	    }
	    
	    private int prims(List<List<List<Integer>>> adj, int n, int k) {
	        HashSet<Integer> visited = new HashSet<>();
	        PriorityQueue<Pair> pq = new PriorityQueue<>();
	        pq.add(new Pair(k, 0));
	        
	        int time = 0;
	        while(!pq.isEmpty()) {
	            Pair rem = pq.remove();
	            
	            if(visited.contains(rem.v)) {
	                continue;
	            }
	            visited.add(rem.v);
	            
	            time = Math.max(time, rem.wt);
	            
	            for(List<Integer> edge: adj.get(rem.v)) {
	                int nbr = edge.get(0);
	                int wt = edge.get(1);
	                
	                if(!visited.contains(nbr)) {
	                    pq.add(new Pair(nbr, rem.wt + wt));
	                }
	            }
	        }
	        
	        if(visited.size() == n) {
	            return time;
	        } else {
	            return -1;
	        }
	    }
	}
}
