package graphs2;

import java.util.Arrays;

public class RedundantConnection {
	private int find(int[] parent, int node) {
        if(parent[node] == -1)
            return node;
        return parent[node] = find(parent, parent[node]);
    }
    
    private boolean union(int[] parent, int[] rank, int node1, int node2) {
        int absr1 = find(parent, node1);
        int absr2 = find(parent, node2);
        
        if(absr1 == absr2) {
            return false;
        } else {
            if(rank[absr1] < rank[absr2]) {
                parent[absr1] = absr2;
            } else if(rank[absr2] < rank[absr1]) {
                parent[absr2] = absr1;
            } else {
                parent[absr1] = absr2;
                rank[absr2]++;
            }
        }
        return true;
    }
    
    private int[] solve(int[][] edges, int n) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 0);
        
        int[] ans = new int[2];
        for(int i = 0; i < edges.length; i++) {
            boolean union = union(parent, rank, edges[i][0] - 1, edges[i][1] - 1);
            if(!union) {
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
            }
        }
        
        return ans;
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        return solve(edges, edges.length);
    }
}
