package binarySearchTrees2;

public class LCA2 {
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	public Node lowestCommonAncestor(Node root, Node n1, Node n2) {
        if(root == null) {
	        return null;
	    }
        
        if(root.data < Math.min(n1.data, n2.data)) {
            return lowestCommonAncestor(root.right, n1, n2);
        } else if(root.data > Math.max(n1.data, n2.data)) {
            return lowestCommonAncestor(root.left, n1, n2);        
        } else {
            return root;
        }
        
    }
}
