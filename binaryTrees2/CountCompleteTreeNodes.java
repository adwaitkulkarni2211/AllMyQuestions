package binaryTrees2;

public class CountCompleteTreeNodes {
	class TreeNode {
		TreeNode left, right;
		int val;
	}
	public int countNodes(TreeNode root) {
        return solve(root);
    }
    
    private int solve(TreeNode root) {
        if(root == null) return 0;
        
        int lh = getLeftHeight(root), rh = getRightHeight(root);
        if(lh == rh)
            return ((int)Math.pow(2, lh)) - 1;
            
        return solve(root.left) + solve(root.right) + 1;
    }
    
    private int getLeftHeight(TreeNode root) {
        int count = 0;
        while(root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
    private int getRightHeight(TreeNode root) {
        int count = 0;
        while(root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
