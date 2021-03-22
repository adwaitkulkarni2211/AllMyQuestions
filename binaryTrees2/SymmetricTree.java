package binaryTrees2;

public class SymmetricTree {
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
	  
	//preferred approach:
	    public boolean isSymmetric(TreeNode root) {
	        return isMirror(root, root);
	    }
	    
	    public boolean isMirror(TreeNode t1, TreeNode t2) {
	        if (t1 == null && t2 == null) return true;
	        if (t1 == null || t2 == null) return false;
	        return (t1.val == t2.val)
	            && isMirror(t1.right, t2.left)
	            && isMirror(t1.left, t2.right);
	    }
	  
	  //My approach:
	  public boolean isSymmetric1(TreeNode root) {
	        lhs(root.left);
	        rhs(root.right);
	        //System.out.println("preL:" + preL + " preR: " + preR);
	        if(preL.equals(preR)) {
	            return true;
	        }
	        return false;
	    }
	    String preL = "";
	    public void lhs(TreeNode node) {
	        if(node == null) {
	            preL += "N";
	            return;
	        }
	        
	        preL += node.val;
	        
	        lhs(node.left);
	        lhs(node.right);
	    }
	    String preR = "";
	    public void rhs(TreeNode node) {
	        if(node == null) {
	            preR += "N";
	            return;
	        }
	        
	        preR += node.val;
	        
	        rhs(node.right);
	        rhs(node.left);
	    }
}
