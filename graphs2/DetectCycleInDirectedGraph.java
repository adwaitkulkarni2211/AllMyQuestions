package graphs2;
import java.util.*;
public class DetectCycleInDirectedGraph {
	// Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V], path = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!visited[i] && dfs(adj, visited, path, i))
                return true;
        }
        
        // return false;
        
        return kahnsAlgo(adj, V);
    }
    
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] path, int src) {
        
        visited[src] = true;
        path[src] = true;
        
        boolean ans = false;
        for(int nbr: adj.get(src)) {
            if(!visited[nbr]) 
                ans = ans || dfs(adj, visited, path, nbr);
            else if(path[nbr]) {
                return true;
            }
        }
        
        path[src] = false;
        
        return ans;
    }
    
    
    private boolean kahnsAlgo(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] indeg = new int[V];
        
        for(int i = 0; i < V; i++) {
            for(int nbr: adj.get(i)) {
                indeg[nbr]++;
            }
        }
        
        return bfs(adj, V, indeg);
    }
    
    private boolean bfs(ArrayList<ArrayList<Integer>> adj, int V, int[] indeg) {
        Queue<Integer> q = new ArrayDeque<>();
        int count = 0;
        
        for(int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty()) {
            int rem = q.remove();
            count++;
            
            for(int nbr: adj.get(rem)) {
                indeg[nbr]--;
                if(indeg[nbr] == 0)
                    q.add(nbr);
            }
        }
        
        if(count == V) {
            return false;
        }
        return true;
    }
}
