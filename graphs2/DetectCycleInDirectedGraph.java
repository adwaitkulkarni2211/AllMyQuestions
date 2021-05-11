package graphs2;
import java.util.*;
public class DetectCycleInDirectedGraph {
    boolean ans;
    public void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] path, int src) {
        
        visited[src] = true;
        path[src] = true;
        
        for(int nbr: graph.get(src)) {
            if(visited[nbr] == false) {
                dfs(graph, visited, path, nbr);
            } else if(path[nbr] == true) {
                ans = true;
                return;
            }
        }
        
        path[src] = false;
    }
    
    public boolean bfsTopoSort_KahnsAlgo(int v, ArrayList<ArrayList<Integer>> graph) {
        int indegree[] = new int[v];
        
        for(ArrayList<Integer> al: graph) {
            for(int nbr: al) {
                indegree[nbr]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        
        while(q.size() > 0) {
            int rem = q.remove();
            count++;
            
            for(int nbr: graph.get(rem)) {
                indegree[nbr]--;
                if(indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }
        
        if(count == v) {
            //topo sort is possible, no cycle
            return false;
        } else {
            //topo sort is not possible, cycle is present
            return true;
        }
    }
    
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[v];
        boolean[] path = new boolean[v];
        ans = false;
        for(int i=0; i<v; i++) {
            if(visited[i] == false) {
                dfs(graph, visited, path, i);
                if(ans) return true;
            }
        }
        return false;
    }
}
