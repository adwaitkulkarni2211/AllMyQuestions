package binarySearchTrees2;

public class ConstructBSTFromPreOrder {
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
	
	//Method 1: sort the preorder array and it will form an inorder array. Now construct
				//Binary Tree from preorder and inorder
	
	//method 2: create a node, and insert it into the BST using normal insert function:
	public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i=1; i<preorder.length; i++) {
            root = insert(root, new TreeNode(preorder[i]));
        }
        return root;
    }
    
    private TreeNode insert(TreeNode node, TreeNode x) {
        if(node == null) {
            return x;
        }
        if(x.val > node.val) {
            node.right = insert(node.right, x);
        } else {
            node.left = insert(node.left, x);
        }
        return node;
    }
    
    
}
