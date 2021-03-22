package binaryTrees2;

import java.util.*;

public class PathSum2Leetcode {
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
	
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path = new ArrayList<>();
        ans = new ArrayList<>();
        solve(root, targetSum, 0);
        return ans;
    }

    List<Integer> path;
    List<List<Integer>> ans;
    private void solve(TreeNode node, int tar, int sum) {
        if(node == null) {
            return;
        }
        
        if(node.left == null && node.right == null) {
            if(sum + node.val == tar) {
                path.add(node.val);
                List<Integer> temp = new ArrayList<>(path);
                ans.add(temp);
                path.remove(path.size() - 1);
            }
        }
        path.add(node.val);
        solve(node.left, tar, sum + node.val);
        solve(node.right, tar, sum + node.val);
        path.remove(path.size() - 1);
    }
}
