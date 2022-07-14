package binaryTrees2;
import java.util.*;

public class IterativePostorder {
	class TreeNode {
		TreeNode left, right;
		int val;
	}
	public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode curr = root;
        while(curr != null || !st.isEmpty()) {
            if(curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek().right;
                if(temp == null) {
                    temp = st.pop();
                    ans.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                } else{
                    curr = temp;
                }
            }
        }
        
        return ans;
    }
}
