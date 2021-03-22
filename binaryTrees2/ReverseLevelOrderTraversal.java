package binaryTrees2;
import java.util.*;
public class ReverseLevelOrderTraversal {
	class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode node) {
        if(node == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> mainQ = new ArrayDeque<>();
        Queue<TreeNode> childQ = new ArrayDeque<>();
        Stack<TreeNode> st = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        mainQ.add(node);
        
        while(mainQ.size() > 0) {
            node = mainQ.remove();
            st.push(node);
            
            if(node.right != null) {
                childQ.add(node.right);
            }
            
            if(node.left != null) {
                childQ.add(node.left);
            }
            
            if(mainQ.size() == 0) {
                st.push(new TreeNode(-1001));
                mainQ = childQ;
                childQ = new ArrayDeque<>();
            }
        }
        st.pop();
        
        List<Integer> levels = new ArrayList<>();
        while(st.size() > 0) {
            node = st.pop();
            if(node.val != -1001) {
                levels.add(node.val);
            } else {
                ans.add(levels);
                levels = new ArrayList<>();
            }
        }
        ans.add(levels);
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
