package binarySearchTrees2;

public class CheckIfBSTContainsDeadEnd {	
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public static boolean isDeadEnd(Node root) {
        return solve(root, 1, Integer.MAX_VALUE);
    }
    
    private static boolean solve(Node root, int lb, int rb) {
        if(root != null && root.data == lb && lb == rb) return true;
        if(root == null) return false;
        
        return solve(root.left, lb, root.data - 1) || solve(root.right, root.data + 1, rb);
    }
}
