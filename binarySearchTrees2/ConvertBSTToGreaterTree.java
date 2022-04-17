package binarySearchTrees2;

public class ConvertBSTToGreaterTree {
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
	
	private int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        solve(root);
        return root;
    }
    
    private void solve(TreeNode root) {
        if(root == null) {
            return;
        }
        
        solve(root.right);
        
        sum += root.val;
        root.val = sum;
        
        solve(root.left);
    }
}
