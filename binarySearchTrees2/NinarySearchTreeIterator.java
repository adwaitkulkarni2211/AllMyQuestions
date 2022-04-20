package binarySearchTrees2;
import java.util.*;

public class NinarySearchTreeIterator {
	class TreeNode {
		TreeNode right, left;
		int val;
		
		TreeNode(int val) {
			this.val = val;
			this.right = this.left = null;
		}
	}
	class BSTIterator {
	    Stack<TreeNode> st;

	    public BSTIterator(TreeNode root) {
	        st = new Stack<>();
	        pushAllLeft(root);
	    }
	    
	    private void pushAllLeft(TreeNode root){ 
	        TreeNode temp = root;
	        while(temp != null) {
	            st.push(temp);
	            temp = temp.left;
	        }
	    }
	    
	    public int next() {
	        TreeNode ret = st.pop();
	        pushAllLeft(ret.right);
	        return ret.val;
	    }
	    
	    public boolean hasNext() {
	        return !st.isEmpty();
	    }
	}

}
