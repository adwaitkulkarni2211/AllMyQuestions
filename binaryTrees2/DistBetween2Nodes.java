package binaryTrees2;

public class DistBetween2Nodes {
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
	
	public static int dist(Node node, int x) {
		if(node == null) {
			return -1;
		}
		if(node.data == x) {
			return 0;
		}
		int l = dist(node.left, x);
		int r = dist(node.right, x);
		if(l == -1 && r == -1) {
			return -1;
		}
		
		return l != -1 ? l + 1 : r + 1;
	}
	
	public static void main(String[] args) {
		//first find the lca of the two nodes and then
		//find the distance between the lca and the node separately 
		//print their sum.
	}
}
