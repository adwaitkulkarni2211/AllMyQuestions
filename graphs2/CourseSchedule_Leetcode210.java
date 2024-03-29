package graphs2;
import java.util.*;
public class CourseSchedule_Leetcode210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0], v = prerequisites[i][1];
            indeg[v]++;
            adj.get(u).add(v);
        }
        
        return kahns_bfs(adj, numCourses, indeg);
    }
    
    private int[] kahns_bfs(List<List<Integer>> adj, int n, int[] indeg) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] ans = new int[n];
        
        for(int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0)
                q.add(i);
        }
        
        int idx = n - 1;
        while(!q.isEmpty()) {
            int rem = q.remove();
            ans[idx--] = rem;
            
            for(int nbr: adj.get(rem)) {
                indeg[nbr]--;
                if(indeg[nbr] == 0)
                    q.add(nbr);
            }
        }
        
        if(idx == -1)
            return ans;
        else
            return new int[0];
    }
}
