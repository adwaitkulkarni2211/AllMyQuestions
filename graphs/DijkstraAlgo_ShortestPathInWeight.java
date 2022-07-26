package graphs;
import java.util.*;
public class DijkstraAlgo_ShortestPathInWeight {
	class Pair implements Comparable<Pair>{
        int v, dist;
        Pair(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
        
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
        public String toString() {
            return "(" + v + ", " + dist + ")";
        }
    }
    
    public int[] dijkstra(int n, int src, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int[] minDist = new int[n];
        Arrays.fill(minDist, (int)1e9);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        pq.add(new Pair(src, 0));
        
        while(!pq.isEmpty()) {
            Pair rem = pq.remove();
            
            if(rem.dist >= minDist[rem.v]) {
                continue;
            }
            minDist[rem.v] = rem.dist;
            
            for(ArrayList<Integer> edge: adj.get(rem.v)) {
                int nbr = edge.get(0), dist = rem.dist + edge.get(1);
                
                if(dist < minDist[nbr])
                    pq.add(new Pair(nbr, dist));
            }
        }
        
        return minDist;
    }
}
