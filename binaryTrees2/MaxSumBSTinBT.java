package binaryTrees2;

public class MaxSumBSTinBT {
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
        TreeNode node;
        Boolean isBST = true;
        int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    }
    
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        Pair ans = solve(root);
        System.out.println(ans);
        return maxSum;
    }
    
    int maxSum;
    
    private Pair solve(TreeNode node) {
        if(node == null) {
            return new Pair();
        }
        
        Pair lp = solve(node.left);
        Pair rp = solve(node.right);
        
        Pair mp = new Pair();
        
        mp.node = node;
        mp.isBST = lp.isBST && rp.isBST && node.val > lp.max && node.val < rp.min;
        if(!mp.isBST) {
            return mp;
        }
        mp.sum = lp.sum + rp.sum + node.val;
        maxSum = Math.max(maxSum, mp.sum);
        mp.max = Math.max(lp.max, Math.max(rp.max, node.val));
        mp.min = Math.min(lp.min, Math.min(rp.min, node.val));
        
        return mp;
    }
}
