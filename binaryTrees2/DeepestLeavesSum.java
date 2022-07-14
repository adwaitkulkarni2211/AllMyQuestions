package binaryTrees2;

public class DeepestLeavesSum {
	class TreeNode {
		TreeNode left, right;
		int val;
	}
	class Solution {
	    class Pair {
	        int ht, sum;
	        Pair(int ht, int sum) {
	            this.ht = ht;
	            this.sum = sum;
	        }
	    }
	    public int deepestLeavesSum(TreeNode root) {
	        return solve(root).sum;
	    }
	    
	    private Pair solve(TreeNode root) {
	        if(root == null) {
	            return new Pair(0, 0);
	        }
	        
	        if(root.left == null && root.right == null) {
	            return new Pair(1, root.val);
	        }
	        
	        Pair lp = solve(root.left);
	        Pair rp = solve(root.right);
	        
	        //3 conditions
	        if(lp.ht > rp.ht) {
	            return new Pair(lp.ht + 1, lp.sum);
	        } else if(rp.ht > lp.ht) {
	            return new Pair(rp.ht + 1, rp.sum);
	        } else {
	            return new Pair(lp.ht + 1, lp.sum + rp.sum);
	        }
	    }
	}
}
