package dynamicProgramming2;

public class BinaryTreeMaximumSumPath {
	class TreeNode {
		TreeNode left, right;
		int val;
	}
	int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        solve(root);
        return res;
    }
    
    private int solve(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int l = solve(root.left);
        int r = solve(root.right);
        
        int temp = Math.max(Math.max(l, r) + root.val, root.val);
        int ans = Math.max(temp, l + r + root.val);
        res = Math.max(res, ans);
        
        return temp;
    }
}
