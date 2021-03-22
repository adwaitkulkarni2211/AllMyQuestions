package binaryTrees2;
import java.util.*;
public class LeafSimilarTrees {
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
	
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        leaves = new ArrayDeque<>();
        ans = true;
        solve(root1, 1);
        solve(root2, 2);
        if(leaves.size() != 0) {
            ans = false;
        }
        return ans;
    }
    
    Queue<Integer> leaves;
    boolean ans;
    
    private void solve(TreeNode node, int flag) {
        if(node == null) {
            return;
        }
        
        solve(node.left, flag);
        solve(node.right, flag);
        
        if(node.left == null && node.right == null) {
            if(flag == 1) {
                leaves.add(node.val);    
            } else {
                if(leaves.size() == 0) {
                    ans = false;
                    return;
                }
                int rem = leaves.remove();
                if(node.val != rem) {
                    ans = false;
                    return;
                }
            }
        }
    }
	
}
