package graphs2;
import java.util.*;
public class CheapestFlightsWithKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        wtAndStops[] visited = new wtAndStops[n];
        for(int i=0; i<n; i++) {
            visited[i] = new wtAndStops(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        //creating adj:
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            
            Edge e = new Edge(u, v, wt);
            adj.get(u).add(e);
        }
        
        //Start Dijkstra's algo
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0, 0));
        
        while(pq.size() > 0) {
            Pair rem = pq.remove();
            
            if(rem.wsf >= visited[rem.vtx].wt && rem.stops >= visited[rem.vtx].stops) {
                continue;
            }
            visited[rem.vtx].wt = rem.wsf;
            visited[rem.vtx].stops = rem.stops;
            
            //check if removed pair contains destination vtx
            if(rem.vtx == dest) {
                if(rem.stops <= k) {
                    return rem.wsf;
                }
            }
            
            for(Edge nbr: adj.get(rem.vtx)) {
                if(rem.wsf + nbr.wt < visited[nbr.dest].wt || rem.stops < visited[nbr.dest].stops) {
                    int stops = 0;
                    if(nbr.dest == dest) {
                        stops = rem.stops;
                    } else {
                        stops = rem.stops + 1;
                    }
                    if(stops > k) {
                        continue;
                    }
                    pq.add(new Pair(nbr.dest, rem.wsf + nbr.wt, stops));
                }
            }
        }
        return -1;
    }
    
    class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) { 
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    
    class Pair implements Comparable<Pair>{
        int vtx, wsf, stops;
        Pair(int vtx, int wsf, int stops) {
            this.vtx = vtx;
            this.wsf = wsf;
            this.stops = stops;
        }
        
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }
    
    class wtAndStops {
        int wt, stops;
        wtAndStops(int wt, int stops) {
            this.wt = wt;
            this.stops = stops;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
