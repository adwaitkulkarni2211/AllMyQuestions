package binaryTrees2;
import java.util.*;

public class IterativePreorder {
	class TreeNode {
		TreeNode left, right;
		int val;
	}
	public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
         solve_rec(root);
         solve_iter(root);
        return solve_morris(root);
    }
    
    private List<Integer> solve_rec(TreeNode root) {
        if(root == null) return new LinkedList<>();
        
        List<Integer> ans = new LinkedList<>();
        ans.add(root.val);
        
        List<Integer> lvals = solve_rec(root.left);
        List<Integer> rvals = solve_rec(root.right);
        
        ans.addAll(lvals);
        ans.addAll(rvals);
        
        return ans;
    }
    
    private List<Integer> solve_iter(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        st.push(root);
        
        while(!st.isEmpty()) {
            TreeNode rem = st.pop();
            ans.add(rem.val);
            
            if(rem.right != null) st.push(rem.right);
            if(rem.left != null) st.push(rem.left);
        }
        
        return ans;
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
                ans.add(curr.val);
                curr = curr.left;
            }
            if(temp.right == curr) {
                temp.right = null;
                curr = curr.right;
            }
        }
        
        return ans;
    }
}
