package genericTrees;
import java.util.*;
public class ForEachLoopInTreesInPreOrder {
	public static class GenericTree implements Iterable<Integer> {
		Node root;
		GenericTree(Node root) {
			this.root = root;
		}
		public Iterator<Integer> iterator() {
			Iterator<Integer> obj = new GTPreOrder(root);
			return obj;
		}
	}
	public static class GTPreOrder implements Iterator<Integer> {
		Integer nextVal; 
		Stack<Pair> st;
		GTPreOrder(Node root) {
			st = new Stack<>();
			st.push(new Pair(root, -1));
			next();
		}
		
		public boolean hasNext() {
			if(nextVal == null) {
				return false;
			} else {
				return true;
			}
		}
		public Integer next() {
			Integer fr = nextVal;
			
			nextVal = null;
			//moves next value forward, if not possible sets it to null
			while (st.size() > 0) {
	            Pair top = st.peek();

	            if (top.state == -1) {
	            	nextVal = top.node.data;
	                top.state++;
	                break;
	            } else if (top.state == top.node.children.size()) {
	                st.pop();
	            } else {
	                Pair cp = new Pair(top.node.children.get(top.state), -1);
	                st.push(cp);
	                top.state++;
	            }
	        }
			return fr;
		}
	}
	
	private static class Pair {
		Node node;
		int state;
		Pair(Node node, int state) {
			this.state = state;
			this.node = node;
		}
	}
}
