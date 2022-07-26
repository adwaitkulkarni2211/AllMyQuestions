package graphs;
import java.util.*;

public class IsGraphBipartite {
	public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        for(int i = 0; i < n; i++) {
             if(visited[i] == 0 && !bfs(graph, visited, i))
                 return false;
            if(visited[i] == 0 && !dfs(graph, visited, i, -1, 1))
                return false;
        }
        return true;
    }
//dfs is much faster here because of lazy evaluation. In bfs we are just trying out everything
    private boolean dfs(int[][] graph, int[] visited, int src, int prev, int set) {
        
        visited[src] = set;
        
        boolean ans = true;
        for(int nbr: graph[src]) {
            if(visited[nbr] == 0)
                ans = ans && dfs(graph, visited, nbr, src, (set == 1) ? 2 : 1);
            else if(nbr != prev) {
                if(visited[nbr] == set)
                    return false;
            }
        }
        
        return ans;
    }
    
    class Pair {
        int v, set;
        Pair(int v, int set) {
            this.v = v;
            this.set = set;
        }
    }
    
    private boolean bfs(int[][] graph, int[] visited, int src) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 1));
        
        while(!q.isEmpty()) {
            Pair rem = q.remove();
            
            if(visited[rem.v] != 0 && visited[rem.v] != rem.set) {
                return false;
            }
            visited[rem.v] = rem.set;
            
            for(int nbr: graph[rem.v]) {
                if(visited[nbr] == 0)
                    q.add(new Pair(nbr, (rem.set == 1) ? 2 : 1));
                else if(visited[nbr] == rem.set)
                    return false;
            }
        }
        
        return true;
    }
}
