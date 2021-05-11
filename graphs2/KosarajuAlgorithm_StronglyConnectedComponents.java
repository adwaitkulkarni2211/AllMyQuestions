package graphs2;
import java.util.*;
public class KosarajuAlgorithm_StronglyConnectedComponents {
	public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<v; i++) {
            if(visited[i] == false) {
                topoSort(adj, st, i, visited);
            }
        }
        
        ArrayList<ArrayList<Integer>> rev = reverseEdges(adj, v);
        
        visited = new boolean[v];
        int count = 0;
        while(st.size() > 0) {
            int src = st.pop();
            if(visited[src] == false) {
                dfs(rev, src, visited);
                count++;
                //System.out.println("count: " + count);
            }    
        }
        return count;
    }
    
    private void topoSort(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int src, boolean[] visited) {
        
        visited[src] = true;
        
        for(int nbr: adj.get(src)) {
            if(visited[nbr] == false) {
                topoSort(adj, st, nbr, visited);
            }
        }
        st.push(src);
    }
    
    private ArrayList<ArrayList<Integer>> reverseEdges(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        
        for(int i=0; i<v; i++) {
            rev.add(new ArrayList<>());
        }
        
        for(int i=0; i<adj.size(); i++) {
            for(int idx: adj.get(i)) {
                rev.get(idx).add(i);
            }
        }
        
        return rev;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> rev, int src, boolean[] visited) {
        
        visited[src] = true;
    
        for(int nbr: rev.get(src)) {
            if(visited[nbr] == false) {
                dfs(rev, nbr, visited);
            }
        }
    }
}
