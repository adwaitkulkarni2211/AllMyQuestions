package graphs;
import java.util.*;
public class PrimsAlgo_MST_MinWiresToConnectAllPCs {
	//og O(NlogN)
	private static int prims_pq(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    	boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        
        int ans = 0;
        while(!pq.isEmpty()) {
            //find node with min dist
            Pair rem = pq.remove();
            
            if(visited[rem.v])
                continue;
            visited[rem.v] = true;
            ans += rem.dist;
            
            for(ArrayList<Integer> edge: adj.get(rem.v)) {
                int u = edge.get(0), dist = edge.get(1);
                
                if(!visited[u]) {
                    pq.add(new Pair(u, dist));
                }
            }
        }
        
        return ans;
    }
	//O(n^2)
	private static int getNodeWithMinDist(int[] minDist, boolean[] nodes) {
        int min = Integer.MAX_VALUE, minIdx = -1;
        for(int i = 0; i < minDist.length; i++) {
            if(!nodes[i] && minDist[i] < min) {
                min = minDist[i];
                minIdx = i;
            }
        }
        
        return minIdx;
    }
    private static void relaxEdges(int v, boolean[] nodes, int[] minDist, int[] parent, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        for(ArrayList<Integer> edge: adj.get(v)) {
            int u = edge.get(0), dist = edge.get(1);
            
            if(!nodes[u] && dist < minDist[u]) {
                minDist[u] = dist;
                parent[u] = v;
            }
        }
    }
    private static int prims(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int[] minDist = new int[n];
        int[] parent = new int[n];
        boolean[] nodes = new boolean[n];
        
        Arrays.fill(minDist, (int)1e9);
        Arrays.fill(parent, -1);
        
        minDist[0] = 0;
        
        for(int e = 0; e < n - 1; e++) {
            //find node with min dist
            int v = getNodeWithMinDist(minDist, nodes);
            
            nodes[v] = true;
            
            relaxEdges(v, nodes, minDist, parent, adj);
        }
        
        //count the total cost
        int cost = 0;
        for(int i = 0; i < minDist.length; i++) {
            cost += minDist[i];
        }
        
        return cost;
    }
    
    private static class Pair {
    	int v, dist;
    	Pair(int v, int dist) {
    		this.v = v;
    		this.dist = dist;
    	}
    }
    
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    	prims_pq(V, adj);
        return prims(V, adj);
    }
}
