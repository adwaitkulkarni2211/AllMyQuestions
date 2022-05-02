package graphs2;
import java.util.*;
public class SmallestStringWithSwaps {
	class Solution {
	    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
	        List<List<Integer>> adj = new ArrayList<>();
	        
	        for(int i=0; i<s.length(); i++) {
	            adj.add(new ArrayList<>());
	        }
	        
	        for(int i=0; i<pairs.size(); i++) {
	            int n1 = pairs.get(i).get(0);
	            int n2 = pairs.get(i).get(1);
	            
	            adj.get(n1).add(n2);
	            adj.get(n2).add(n1);
	        }
	        
	        boolean[] visited = new boolean[s.length()];
	        
	        char[] ans = new char[s.length()];
	        
	        for(int i=0; i<s.length(); i++) {
	            if(!visited[i]) {
	                List<Character> chars = new ArrayList<>();
	                List<Integer> idxs = new ArrayList<>();
	                getConnectedComponents(adj, s, i, visited, chars, idxs);
	                
	                Collections.sort(chars);
	                Collections.sort(idxs);
	                
	                for(int j=0; j<chars.size(); j++) {
	                    ans[idxs.get(j)] = chars.get(j);
	                }
	            }
	        }
	        
	        return String.valueOf(ans);
	        
	    }
	    
	    private void getConnectedComponents(List<List<Integer>> adj, String str, int v, boolean[] visited, List<Character> chars, List<Integer> idxs) {
	        
	        visited[v] = true;
	        
	        chars.add(str.charAt(v));
	        idxs.add(v);
	        
	        for(int nbr: adj.get(v)) {
	            if(!visited[nbr])
	                getConnectedComponents(adj, str, nbr, visited, chars, idxs);
	        }
	    }
	}
}
