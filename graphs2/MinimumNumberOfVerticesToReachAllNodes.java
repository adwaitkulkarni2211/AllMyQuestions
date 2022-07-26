package graphs2;
import java.util.*;
public class MinimumNumberOfVerticesToReachAllNodes {
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		//vertices with indeg 0 is the ans!
        int[] indeg = new int[n];
        
        for(List<Integer> edge: edges) {
            indeg[edge.get(1)]++;
        }
        
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < indeg.length; i++)
            if(indeg[i] == 0) ans.add(i);
        
        return ans;
    }
}
