package binaryTrees2;
import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorder {
	class TreeNode {
		TreeNode left, right;
		int val;
		TreeNode(int val) {
			this.val = val;
		}
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        
        return solve(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    
    private TreeNode solve(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
        if(postStart > postEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int inRoot = map.getOrDefault(root.val, -1);
        int numsLeft = inRoot - inStart;
        
        root.left = solve(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, map);
        root.right = solve(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, map);
        
        
        return root;
    }
}
