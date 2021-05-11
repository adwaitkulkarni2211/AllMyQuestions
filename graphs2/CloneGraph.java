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
    
    class Pair {
        Node clone, orig;
        Pair(Node clone, Node orig) {
            this.clone = clone;
            this.orig = orig;
        }
    }
}
