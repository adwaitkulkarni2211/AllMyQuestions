package graphs2;
import java.util.*;
public class DetectCycleInUndirectedGraph {
	boolean ans;
    public void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int src, int prev) {
        
        visited[src] = true;
        for(int nbr: graph.get(src)) {
            if(visited[nbr] == false) {
                dfs(graph, visited, nbr, src);
            } else if(nbr != prev) {
                ans = true;
                return;
            }
        }
        visited[src] = false;
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
    
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> graph) {
    	//this is for dfs, will be the same for bfs.
        boolean[] visited = new boolean[v];
        ans = false;
        for(int i=0; i<v; i++) {
            if(visited[i] == false) {
                dfs(graph, visited, i, -1);
                if(ans) {
                    return true;
                }
            }
        }
        return false;
    }
}
