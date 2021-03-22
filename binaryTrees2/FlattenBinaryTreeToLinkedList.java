package binaryTrees2;

public class FlattenBinaryTreeToLinkedList {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	 }
	public void flatten(TreeNode root) {
        preOrder(root);
    }

    void preOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        
        preOrder(node.left);
        preOrder(node.right);
        
        TreeNode tempr = node.right;
        TreeNode templ = node.left;
        
        node.left = null;
        node.right = templ;
        
        while(templ != null && templ.right != null) {
            templ = templ.right;
        }
        if(templ != null)
            templ.right = tempr;
        else 
            node.right = tempr;
    }
}
