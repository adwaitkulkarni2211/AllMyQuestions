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
	class Pair {
        TreeNode node, tail;
        Pair(TreeNode node, TreeNode tail) {
            this.node = node;
            this.tail = tail;
        }
    }
    
    private Pair solve(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        Pair lp = solve(root.left);
        Pair rp = solve(root.right);
        
        if(lp == null && rp == null) {  //leaf node's tail is node itself
            return new Pair(root, root);
        } else if(lp == null) { //right side is not null, so nothing to do
            return new Pair(root, rp.tail);
        } else if(rp == null) { //right side is null, so attach left to right
            root.right = root.left;
            
            root.left = null;
            
            return new Pair(root, lp.tail);
        } else {
            root.right = lp.node;
            lp.tail.right = rp.node;
            
            root.left = null;

            return new Pair(root, rp.tail);    
        }
    }
    
    public void flatten(TreeNode root) {
        solve(root);
    }
}
