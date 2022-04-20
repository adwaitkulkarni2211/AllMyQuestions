package binarySearchTrees2;

public class RecoverBinarySearchTree {
	class TreeNode {
		TreeNode right, left;
		int val;
		
		TreeNode(int val) {
			this.val = val;
			this.right = this.left = null;
		}
	}
	public void recoverTree(TreeNode root) {
        first = middle = last = prev = null;
        
        inOrder(root);
        
        if(first != null && last != null) {
            swap(first, last);
        } else if(first != null && middle != null){
            swap(first, middle);
        }
    }
    
    TreeNode first, middle, last, prev;
    
    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left);
        
        if(prev != null && root.val < prev.val) {
            if(first == null) {
                first = prev;
                middle = root;
            }
            else if(last == null) last = root;
        }
        
        prev = root;
        
        inOrder(root.right);
    }
    
    private void swap(TreeNode n1, TreeNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}
