package graphs2;
import java.util.*;

public class ArticulationPoint {
	int time;
    ArrayList<Integer> ans;
    boolean[] isArticulation;
    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] tod, int[] low, int parent, int src) {
        
        visited[src] = true;
        tod[src] = low[src] = time++;
        
        int children = 0;
        for(int nbr: adj.get(src)) {
            if(nbr == parent)
                continue;
            
            if(!visited[nbr]) {
                dfs(adj, visited, tod, low, src, nbr);
                low[src] = Math.min(low[src], low[nbr]);
                
                if(low[nbr] >= tod[src] && parent != -1) {
                    isArticulation[src] = true;
                }
                children++;
            } else {
                low[src] = Math.min(low[src], tod[nbr]);
            }
        }
        
        if(parent == -1 && children > 1) isArticulation[src] = true;
    }
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj) {
        time = 0;
        ans = new ArrayList<>();
        isArticulation = new boolean[n];
        
        int[] tod = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i])
                dfs(adj, visited, tod, low, -1, i);
        }
        
        for(int i = 0; i < n; i++) {
            if(isArticulation[i])
                ans.add(i);
        }
        
        if(ans.size() == 0) {
            ans.add(-1);
        }
        
        return ans;
    }
}
