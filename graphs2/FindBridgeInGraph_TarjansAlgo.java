package graphs2;
import java.util.*;
public class FindBridgeInGraph_TarjansAlgo {
	private List<List<Integer>> constructAdj(List<List<Integer>> connections, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < connections.size(); i++) {
            int src = connections.get(i).get(0), dest = connections.get(i).get(1);
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        
        return adj;
    }
    
    int time;
    List<List<Integer>> ans;
    private void dfs(List<List<Integer>> adj, boolean[] visited, int[] tod, int[] low, int parent, int src) {
        
        visited[src] = true;
        time++;
        tod[src] = low[src] = time;
        
        for(int nbr: adj.get(src)) {
            if(nbr == parent)
                continue;
            
            if(!visited[nbr]) {
                dfs(adj, visited, tod, low, src, nbr);
                low[src] = Math.min(low[src], low[nbr]);
                
                if(low[nbr] > tod[src]) {
                    List<Integer> bridge = Arrays.asList(src, nbr);
                    ans.add(bridge);
                }
            } else {
                low[src] = Math.min(low[src], tod[nbr]);
            }
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        time = 0;
        ans = new ArrayList<>();
        
        List<List<Integer>> adj = constructAdj(connections, n);
        
        int[] tod = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i])
                dfs(adj, visited, tod, low, -1, i);
        }
        
        return ans;
    }
}
