package binaryTrees2;
import java.util.*;
public class KthAncestorOfANode {
	static class Node {
		int data;
		Node left, right;
		
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public static void kthAncestor(Node root, int k, Node node) {
		if(root == null) {
			return;
		}
		if(root == node) {
			path.add(root);
			kth = path.get(path.size() - k).data;
			return;
		}
		path.add(root);
		kthAncestor(root.left, k, node);
		kthAncestor(root.right, k, node);
		path.remove(path.size() - 1);
	}
	static ArrayList<Node> path;
	static int kth;
	public static void main(String[] args) {
		Node root = new Node(1);
		path = new ArrayList<>();
		kth = -1;
		kthAncestor(root, 2, new Node(2));
		System.out.println(kth);

	}

}
