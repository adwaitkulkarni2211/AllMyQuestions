package graphs2;
import java.util.*;

public class MinCostToConnectAllCoins {
	class Edge implements Comparable<Edge>{
        int v, nbr, cost;
        Edge(int v, int nbr, int cost) {
            this.v = v;
            this.nbr = nbr;
            this.cost = cost;
        }
        
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
        public String toString() {
            return "{" + this.v + "->" + this.nbr + ": " + this.cost + "}";
        }
    }
    public int minCostConnectPoints(int[][] points) {
        @SuppressWarnings("unchecked")
		List<Edge>[] adj = new List[points.length];
        
        for(int i = 0; i < points.length; i++) {
            adj[i] = new ArrayList<>();
            for(int j = 0; j < points.length; j++) {
                int v11 = points[i][0];
                int v12 = points[i][1];
                int v21 = points[j][0];
                int v22 = points[j][1];
                int cost = manhattan(v11, v21, v12, v22);
                
                adj[i].add(new Edge(i, j, cost));
            }
            // System.out.println(adj[i]);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        pq.add(new Edge(0, 0, 0));
        int totCost = 0;
        
        while(pq.size() > 0) {
            Edge rem = pq.remove();
            
            if(visited.contains(rem.nbr)) {
                continue;
            }
            
            visited.add(rem.nbr);
            
            totCost += rem.cost;
            
            if(visited.size() == points.length) {
                break;
            }
            
            for(Edge e: adj[rem.nbr]) {
                if(!visited.contains(e.nbr))
                    pq.add(e);
            }
            // System.out.println("visited: " + visited + " totcost: " + totCost);
            // System.out.println("for v: " + rem.nbr + " pq: " + pq);
        }
        
        return totCost;
    }
    
    private int manhattan(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
