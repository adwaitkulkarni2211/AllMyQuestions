package binaryTrees2;
import java.util.*;
public class VerticalOrderTraversal {
	static class Node {
		int data = -1;
		Node left = null, right = null;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	static class Pair {
        int hd;
        Node node;
        Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }
	static ArrayList<Pair> vot = new ArrayList<>();
	static void verticalOrderTraversal(Node node, int hd) {
		if(node == null) {
			return;
		}
		
		Pair p = new Pair(0, node);
		vot.add(p);
		
		verticalOrderTraversal(node.left, hd - 1);
		verticalOrderTraversal(node.right, hd + 1);
	}
	
	static class sortByHd implements Comparator<Pair> { 
	    public int compare(Pair a, Pair b) { 
	        return a.hd - b.hd; 
	    } 
	} 
	
	public static void main(String[] args) {
		Collections.sort(vot, new sortByHd());
		
	}
}
