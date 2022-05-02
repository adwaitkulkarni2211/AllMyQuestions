package graphs2;
import java.util.*;

public class EvaluateDivision {
	class Edge {
        String n1, n2;
        double cost;
        Edge(String n1, String n2, double cost) {
            this.n1 = n1;
            this.n2 = n2;
            this.cost = cost;
        }
        public String toString() {
            return "{" + n1 + "->" + n2 + ":" + cost + "}";
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Edge>> adj = formAdj(equations, values);
        //System.out.println(adj);
        
        double[] ans = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); i++) {
            ans[i] = bfs(adj, queries.get(i).get(0), queries.get(i).get(1));    
        }
        
        return ans;
    }
    
    private HashMap<String, List<Edge>> formAdj(List<List<String>> equations, double[] values) {
        HashMap<String, List<Edge>> adj = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++) {
            String n1 = equations.get(i).get(0), n2 = equations.get(i).get(1);
            
            if(adj.containsKey(n1)) {
                adj.get(n1).add(new Edge(n1, n2, values[i]));
            } else {
                List<Edge> nbrs = new ArrayList<>();
                nbrs.add(new Edge(n1, n2, values[i]));
                adj.put(n1, nbrs);
            }
            
            if(adj.containsKey(n2)) {
                adj.get(n2).add(new Edge(n2, n1, 1 / values[i]));
            } else {
                List<Edge> nbrs = new ArrayList<>();
                nbrs.add(new Edge(n2, n1, 1 / values[i]));
                adj.put(n2, nbrs);
            }
        }
        
        return adj;
    }
    
    class Pair {
        String node;
        double cost;
        Pair(String node, double cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    
    private double bfs(HashMap<String, List<Edge>> adj, String src, String dest) {
        //System.out.println("src: " + src + " dest: " + dest);
        if(!adj.containsKey(src) || !adj.containsKey(dest)) {
            return -1 * 1.0;
        }
        
        HashSet<String> visited = new HashSet<>();
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 1.0));

        while(q.size() > 0) {
            Pair rem = q.remove();
            
            if(visited.contains(rem.node))
                continue;
            visited.add(rem.node);
            
            //System.out.println("rem.node: " + rem.node + " rem.cost: " + rem.cost + " totCost: " + totCost);
            
            if(rem.node.equals(dest)) {
                return rem.cost;
            }
            
            for(Edge e: adj.get(rem.node)) {
                if(!visited.contains(e.n2))
                    q.add(new Pair(e.n2, rem.cost * e.cost));
            }
        }
        
        return -1 * 1.0;
    }
}
