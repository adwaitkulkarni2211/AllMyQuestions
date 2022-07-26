package graphs2;
import java.util.*;
public class DetectCycleInUndirectedGraph {
	private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src, int prev) {
        visited[src] = true;
        
        boolean ans = false;
        for(int nbr: adj.get(src)) {
            if(!visited[nbr]) {
                ans = ans || dfs(adj, visited, nbr, src);
            } else if(nbr != prev) {
                return true;
            }
        }
        
        return ans;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int src) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        
        while(q.size() > 0) {
            int rem = q.remove();
            
            if(visited[rem] == true) {
                    return true;
            } else {
                visited[rem] = true;
            }
            
            for(int nbr: graph.get(rem)) {
                if(visited[nbr] == false)
                    q.add(nbr);
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i] && dfs(adj, visited, i, -1)) {
                return true;
            }
        }
        return false;
    }
}
