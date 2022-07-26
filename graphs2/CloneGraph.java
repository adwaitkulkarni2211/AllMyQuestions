package graphs2;
import java.util.*;
public class CloneGraph {
	
	class Node {
		int val;
		List<Node> neighbors;
		
		Node(int val) {
			this.val = val;
			neighbors = new ArrayList<>();
		}
	}
	public Node cloneGraph(Node node) {
        return dfs(node, new Node[101]);
    }
	private Node dfs(Node node, Node[] visited) {
        if(node == null) return null;
        
        Node nn = new Node(node.val);
        visited[node.val] = nn;
        
        for(Node neighbor: node.neighbors) {
            if(visited[neighbor.val] == null)
                nn.neighbors.add(dfs(neighbor, visited));
            else 
                nn.neighbors.add(visited[neighbor.val]);
        }
        
        return nn;
    }
	
	class Pair {
        Node clone, orig;
        Pair(Node clone, Node orig) {
            this.clone = clone;
            this.orig = orig;
        }
    }
	
	public Node bfs(Node node) {
        if(node == null) {
            return null;
        }
        Queue<Pair> q = new ArrayDeque<>();
        Node root = new Node(node.val);
        q.add(new Pair(root, node));
        
        Node visited[] = new Node[101];
        visited[1] = root;
        
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            for(Node n: rem.orig.neighbors) {                
                if(visited[n.val] == null) {
                    Node nn = new Node(n.val);
                    visited[n.val] = nn;
                    rem.clone.neighbors.add(nn);
                    q.add(new Pair(nn, n));
                } else {
                    rem.clone.neighbors.add(visited[n.val]);
                }
            }
        }
        return root;
    }
}
