package binaryTrees2;

public class KSumPaths {
	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
	
	int count;
    public int pathSum(Node root, int tar) {
        count = 0;
        traverse(root, tar);
        return count;
    }
    
    private void traverse(Node node, int tar) {
        if(node == null) {
            return;
        }
        solve(node, tar, 0);
        traverse(node.left, tar);
        traverse(node.right, tar);
    }
    
    private void solve(Node node, int tar, int sum) {
        if(node == null) {
            return;
        }
        
        if(sum + node.data == tar) {
            count++;
        }
        
        solve(node.left, tar, sum + node.data);
        solve(node.right, tar, sum + node.data);
    }
}
