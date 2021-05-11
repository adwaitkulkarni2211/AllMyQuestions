package graphs2;
import java.util.*;
public class FindBridgeInGraph_TarjansAlgo {
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ans = new ArrayList<>();
        time = 0;
        //forming adj:
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> li: connections) {
            adj.get(li.get(0)).add(li.get(1));
            adj.get(li.get(1)).add(li.get(0));
        }
        
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        
        dfs(adj, disc, low, visited, 0, 0);
        
        return ans;
    }
    
    List<List<Integer>> ans;
    int time;
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int[] disc, int[] low, boolean[] visited, int src, int par) {
       
        visited[src] = true;
        disc[src] = time;
        low[src] = time;
        int lowVal = low[src];
        
        for(int nbr: adj.get(src)) {
            if(visited[nbr] == false && par != nbr) {
                time++;
                dfs(adj, disc, low, visited, nbr, src);
            }
            //if there is a back edge
            if(par != nbr)
                low[src] = Math.min(low[src], low[nbr]);
            
        }
        if(low[src] == lowVal && par != src) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(par);
            edge.add(src);
            ans.add(edge);
        }
    }
}
