package binaryTrees2;

public class DirectionsFromSrcToDestInBT {
	class TreeNode {
		int val;
		TreeNode left, right;
	}
	class Solution {
	    private TreeNode lca(TreeNode root, int p, int q) {
	        if(root == null) return null;
	        if(root.val == p || root.val == q) return root;
	        
	        TreeNode l = lca(root.left, p, q);
	        TreeNode r = lca(root.right, p, q);
	        
	        if(l == null && r == null) return null;
	        if(l != null && r != null) return root;
	        
	        return (l == null) ? r : l;
	    }
	    class Pair {
	        int ht;
	        StringBuilder path;
	        boolean pastLCA;
	        Pair(int ht, StringBuilder path, boolean pastLCA) {
	            this.ht = ht;
	            this.path = path;
	            this.pastLCA = pastLCA;
	        }
	    }
	    
	    private Pair find(TreeNode root, TreeNode lca, int val) {
	        if(root == null) return null;
	        if(root.val == val) {
	            if(lca.val == root.val)
	                return new Pair(0, new StringBuilder(), true);
	            else
	                return new Pair(0, new StringBuilder(), false);
	        }
	        
	        Pair lp = find(root.left, lca, val);
	        if(lp != null) {
	            if(lp.pastLCA) return lp;
	            
	            if(root.val == lca.val)
	                return new Pair(lp.ht + 1, lp.path.append("L"), true);
	            else
	                return new Pair(lp.ht + 1, lp.path.append("L"), false);
	        }
	        
	        Pair rp = find(root.right, lca, val);
	        if(rp != null) {
	            if(rp.pastLCA) return rp;
	            
	            if(root.val == lca.val)
	                return new Pair(rp.ht + 1, rp.path.append("R"), true);
	            else
	                return new Pair(rp.ht + 1, rp.path.append("R"), false);
	        }
	        
	        return null;
	    }
	    public String getDirections(TreeNode root, int src, int dest) {
	        TreeNode lca = lca(root, src, dest);
	        Pair start = find(root, lca, src);
	        Pair end = find(root, lca, dest);
	        
	        StringBuilder ans = new StringBuilder();
	        for(int i = 0; i < start.ht; i++)
	            ans.append("U");
	        
	        ans.append(end.path.reverse());
	        return ans.toString();
	    }
	}
}
