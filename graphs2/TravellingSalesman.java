package graphs2;

public class TravellingSalesman {
	public int total_cost(int[][] cost) {
        return solve(cost, new boolean[cost.length], cost.length, 0, 1);
    }
    
    private int solve(int[][] cost, boolean[] visited, int n, int src, int steps) {
        if(steps == n) {
            return cost[src][0];
        }
        
        visited[src] = true;
        
        int ans = (int)1e9;
        for(int i = 0; i < n; i++) {
            if(!visited[i])
                ans = Math.min(ans, solve(cost, visited, n, i, steps + 1) + cost[src][i]);
        }
        
        visited[src] = false;
        
        return ans;
    }
}
