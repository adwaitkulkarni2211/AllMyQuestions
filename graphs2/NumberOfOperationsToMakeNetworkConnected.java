package graphs2;
import java.util.*;
public class NumberOfOperationsToMakeNetworkConnected {
ArrayList<ArrayList<Integer>> comps;
    
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) {
            return -1;
        }
        ArrayList<ArrayList<Integer>> adj = constructAdj(n, connections);
        
        boolean visited[] = new boolean[n];
        comps = new ArrayList<>();
        for(int v=0; v<n; v++) {
            if(visited[v] == false) {
                ArrayList<Integer> component = new ArrayList<>();
                getConnectedComps(adj, v, visited, component);
                comps.add(component);
            }            
        }
        return comps.size() - 1;
    }
    
    private ArrayList<ArrayList<Integer>> constructAdj(int n, int[][] connections) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<connections.length; i++) {
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        
        return adj;
    }
    
    private void getConnectedComps(ArrayList<ArrayList<Integer>> adj, int src, boolean visited[], ArrayList<Integer> component) {
        
        visited[src] = true;
        for(int nbr: adj.get(src)) {
            if(visited[nbr] == false) {
                component.add(nbr);
                getConnectedComps(adj, nbr, visited, component);
            }
        }
    }
}
