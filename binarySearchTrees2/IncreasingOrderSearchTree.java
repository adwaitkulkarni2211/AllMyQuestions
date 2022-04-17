package binarySearchTrees2;

public class IncreasingOrderSearchTree {
	class TreeNode {
		TreeNode left, right;
		int val;
		TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	
	TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        curr = new TreeNode(-1);
        TreeNode ans = curr;
        
        inOrder(root);
        return ans.right;
    }
    
    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left);
        
        root.left = null;
        curr.right = root;
        curr = root;
        
        inOrder(root.right);
    }
}
