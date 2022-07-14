package binaryTrees2;
import java.util.*;
public class IterativeInorder {
	class TreeNode {
		TreeNode left, right;
		int val;
	}
	public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
         solve_iter(root);
         solve_rec(root);
        return solve_morris(root);
    }
    
    private List<Integer> solve_iter(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        while(true) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            if(st.isEmpty()) break;
            
            root = st.pop();
            ans.add(root.val);
            
            root = root.right;
        }
        
        return ans;
    }
    
    private List<Integer> solve_rec(TreeNode root) {
        if(root == null) return new LinkedList<>();
        
        List<Integer> lvals = solve_rec(root.left);
        lvals.add(root.val);
        List<Integer> rvals = solve_rec(root.right);
        
        lvals.addAll(rvals);
        
        return lvals;
    }
    
    private List<Integer> solve_morris(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        
        while(curr != null) {
            TreeNode temp = curr.left;
            if(temp == null) {
                ans.add(curr.val);
                curr = curr.right;
                continue;
            }
            
            while(temp.right != null && temp.right != curr) {
                temp = temp.right;
            }
            
            if(temp.right == null) {
                temp.right = curr;
                curr = curr.left;
            }
            if(temp.right == curr) {
                temp.right = null;
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        
        return ans;
    }
}
