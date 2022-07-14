package binaryTrees2;
import java.util.*;

public class DeleteNodesAndReturnForest {
	class TreeNode {
		TreeNode left, right;
		int val;
	}
	class Solution {
	    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
	        List<TreeNode> ans = new ArrayList<>();
	        HashSet<Integer> toDelete = new HashSet<>();
	        for(int num: to_delete) toDelete.add(num);
	        
	        solve(root, null, ans, toDelete);
	        
	        return ans;
	    }
	    
	    private TreeNode solve(TreeNode root, TreeNode prev, List<TreeNode> ans, HashSet<Integer> toDelete) {
	        if(root == null) return null;
	        
	        root.left = solve(root.left, root, ans, toDelete);
	        root.right = solve(root.right, root, ans, toDelete);
	        
	        if(toDelete.contains(root.val)) {
	            if(root.left != null) ans.add(root.left);
	            if(root.right != null) ans.add(root.right);
	            return null;
	        }
	        
	        if(prev == null) ans.add(root);
	        return root;
	    }
	}
}
