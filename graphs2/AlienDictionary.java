package graphs2;
import java.util.*;
public class AlienDictionary {
	public String findOrder(String [] dict, int n, int k) {
        ArrayList<ArrayList<Character>> adj = new ArrayList<>();
        for(int i=0; i<k; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<dict.length - 1; i++) {
            String w1 = dict[i];
            String w2 = dict[i + 1];
            
            for(int j=0; j<Math.min(w1.length(), w2.length()); j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j) - 'a').add(w2.charAt(j));
                    break;
                }
            }
        }
        
        boolean visited[] = new boolean[k];
        ArrayList<Character> ans = new ArrayList<>();
        for(int i=0; i<k; i++) {
            if(visited[i] == false) {
                topoSort(adj, i, ans, visited);
            }
        }
        
        Collections.reverse(ans);
        //System.out.println(ans);
        return String.valueOf(ans);
    }
    
    private void topoSort(ArrayList<ArrayList<Character>> adj, int src, ArrayList<Character> order, boolean[] visited) {
        
        visited[src] = true;
        
        for(char ch: adj.get(src)) {
            if(visited[ch - 'a'] == false) {
                topoSort(adj, ch - 'a', order, visited);
            }
        }
        
        char toAdd = (char)(src + 'a');
        order.add(toAdd);
        //System.out.println(order);
    }
}
