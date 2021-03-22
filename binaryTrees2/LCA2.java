package binaryTrees2;

public class LCA2 {
	class Node {
		int data;
		Node left, right;
	}
	
	public static Node LCA(Node node, int n1, int n2) {
		if(node == null) {
			return null;
		}
		if(node.data == n1 || node.data == n2) {
			return node;
		}
		Node l = LCA(node.left, n1, n2);
		Node r = LCA(node.right, n1, n2);
		
		if(l != null && r != null) {
			return node;
		}
		if(l == null && r == null) {
			return null;
		}
		return l != null ? l : r;
	}
}
