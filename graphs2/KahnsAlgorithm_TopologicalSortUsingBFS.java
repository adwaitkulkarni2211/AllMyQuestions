package graphs2;
import java.util.*;

public class KahnsAlgorithm_TopologicalSortUsingBFS {
	public boolean kahnsAlgo(ArrayList<ArrayList<Integer>> adj, int V) {
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
            return true;
        }
        return false;
    }
}
