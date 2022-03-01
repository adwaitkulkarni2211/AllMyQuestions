package binaryTrees2;
import java.util.*;

public class iterativeInorderTraversal {
	private class TreeNode {
		int val;
		TreeNode left, right;
	}
	
	public static void morrisTraversal(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		pushAllLeft(st, root);
		
		while(st.size() > 0) {
			TreeNode rem = st.pop();
			System.out.print(rem.val);
			pushAllLeft(st, rem.right);
		}
		
	}
	
	public static void pushAllLeft(Stack<TreeNode> st, TreeNode node) {
		while(node != null) {
			st.push(node);
			node = node.left;
		}
	}
	
	public static void main(String[] args) {
		
	}

}
